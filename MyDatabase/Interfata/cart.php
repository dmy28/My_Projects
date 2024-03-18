<?php
require('db_connection.php');
session_start();


require_once("component.php");
require_once("db_connection .php");

if(isset($_POST['remove']))
{
    foreach($_SESSION['cart'] as $key => $value)
    {
      if($value["product_id"] == $_GET['id'])
      {
        unset($_SESSION['cart'][$key]);
        $_SESSION['cart'] = array_values($_SESSION['cart']);

        $sql_locuri = "SELECT * FROM locuri";
        $result_locuri = mysqli_query($conn,$sql_locuri);

        $spectacol_id = $_GET['id'];
        $sql_spectacol = "SELECT * FROM spectacol WHERE id_spectacol = $spectacol_id";
        $result_spectacol = mysqli_query($conn,$sql_spectacol);

        if(mysqli_num_rows($result_locuri) > 0)
        {
          if(mysqli_num_rows($result_spectacol) > 0)
          {
            while($row_spectacol = mysqli_fetch_assoc($result_spectacol))
            {
              while($row_locuri = mysqli_fetch_assoc($result_locuri))
              {
                $row_ing = $row_locuri['denumire_ing'];
                $product_quantity = $value["quantity"];
                if( $row_spectacol[$row_ing] >= 1 )
                {
                    $cantitate = $row_locuri['cantitate'] +  $product_quantity * $row_spectacol[$row_ing];

                    $ing_name = $row_locuri['denumire_ing'];
                  }
              }
            }
          }
        }

      }
    }
}

if(isset($_POST['refresh_price']))
{
  foreach($_SESSION['cart'] as $key => $value)
  {
    if($value["product_id"] == $_GET['id'])
    {
      if($_POST['quantity'] == 0)
      {
        unset($_SESSION['cart'][$key]);
        $_SESSION['cart'] = array_values($_SESSION['cart']);
        echo "<script>window.location= 'cart.php'</script>";
      }else {
        $_SESSION['cart'][$key]['quantity'] = $_POST['quantity'];
      }

    }
  }
}

 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <title>Cart</title>
  </head>

  <style>
      body, html {height: 100%}
      body,h1,h2,h3,h4,h5,h6 {font-family: "Animatic SC", sans-serif}

      #cart-count{
        text-align: center;
        padding: 0 0.9rem 0.1rem 0.9rem;
        border-radius: 3rem;
      }
      .bar-item
      {
        color: white;
      }
      .shopping-cart
      {
        padding: 3% 0;
      }
      .cart-items+.cart-items{
        padding: 2% 0;
      }
  </style>


  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a href="index.php" class="bar-item button nav-link">HOME</a>
        <a href="#menu" class="bar-item button nav-link">SPECTACOLE</a>
        <a href="#cart" class="bar-item button nav-link">COS</a>
        <a href="#myMap" class="bar-item button nav-link">CONTACT</a>

    
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="mr-auto"></div>
            <div class="navbar-nav">
              <a href="cart.php" class="nav-item nav-link active">
                <h5 class="px-5 cart">
                  <i class="fas fa-shopping-cart"></i>&nbsp;Cart&nbsp;
                <?php if (isset($_SESSION['cart'])) {
                  $count = 0;
                  $prod_quantity = array_column($_SESSION['cart'],'quantity');
                  foreach ($prod_quantity as $pq) {
                    $count += $pq;
                  }
                  echo "<span id='cart-count' class='text-warning bg-light'> $count</span>";
                } else {
                  echo "<span id='cart-count' class='text-warning bg-light'> 0</span>";
                } ?>
                </h5>
              </a>
            </div>
          </div>
        </div>
    </nav>


  <body class="bg-light">
    <div class="container-fluid">
      <div class="row px-5">
        <div class="col-md-7">
          <div class="shopping-cart">
            <h6>Cosul meu</h6>
            <hr>
                <?php
                $total = 0;
                if(isset($_SESSION['cart']))
                {
                  if(count($_SESSION['cart'])==0)
                  {
                    session_destroy();
                  }
                  $product_id = array_column($_SESSION['cart'],'product_id');
                  $sql = "SELECT * FROM spectacole";
                  $result = mysqli_query($conn,$sql);

                  if(mysqli_num_rows($result) > 0)
                  {
                    while($row = mysqli_fetch_assoc($result))
                    {
                      foreach ($_SESSION['cart'] as $key => $val ) {
                        if($row['id_spectacol']==$val['product_id']){
                        cartElement($row['nume'],$row['pret'],$row['ID_spectacol'],(int)$val['quantity']);
                        $total += (double)$row['pret']*(int)$val['quantity'];
                      }
                    }
                  }
                }
              }else {

                echo "<h5>Cart is empty</h5>";
                session_destroy();
              }
                  ?>
          </div>

        </div>
        <div class="col-md-4 offset-md-1 border rounded mt-5 bg-white h-25">
          <div class="pt-4">
            <h6>Detalii plata</h6>
            <hr>
            <div class="row price-details">
              <div class="col-md-6">
                <?php
                  if (isset($_SESSION['cart'])) {
                    $count = 0;
                    $prod_quantity = array_column($_SESSION['cart'],'quantity');
                    foreach ($prod_quantity as $pq) {
                      $count += $pq;
                    }
                    echo "<h6>Pret ($count produse)</h6>";
                  }
                  else {
                    echo "<h6>Pret (0 produse)</h6>";
                  }
                 ?>
                   
                   
                    <h6>Cost Total</h6>
                </div>
               
              </div>
            </div>
          
          </div>
        </div>
      </div>

    </div>


  </body>
</html>

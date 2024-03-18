<?php

function cartElement($productName, $productPrice, $productId, $productQuantity)
{
  $totalPrice = $productPrice * $productQuantity;
  $element = "<form class='cart-items' action='cart.php?id=$productId' method='post'>
      <div class='border rounded'>
        <div class='row bg-white'>
              <div class='com-md-3 '></div>
              <div class='col-md-6'>
              <h5 class='pt-2'>$productName</h5>
              <small class='text-secondary'>Distribuitor: Spectacole Iasi</small>
              <h5 class='pt-2'>$totalPrice</h5>
              <button type='submit' class='btn btn-danger mx-2' name='remove'>Remove</button>
              </div>
              <div class='col-md-3 py-5'>
              <div class=''>
                
                </div>
              </div>
              </div>
              </div>
<div class='col-md-5'></div>

    </form>";

    printf($element);
}

 ?>

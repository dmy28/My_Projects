<?php
include 'db_connect.php';

function adaugaClient($nume, $prenume, $adresa, $email, $telefon) {
    global $conn;
    $sql = "INSERT INTO Client (Nume, Prenume, Adresa, Email, Telefon) VALUES ('$nume', '$prenume', '$adresa', '$email', '$telefon')";
    $conn->query($sql);
}

function getClienti() {
    global $conn;
    $sql = "SELECT * FROM Client";
    $result = $conn->query($sql);
    $clienti = [];
    while ($row = $result->fetch_assoc()) {
        $clienti[] = $row;
    }
    return $clienti;
}
?>

<DOCTYPE html>
<html>
    <title> SPECTACOLE</title>
    <meta charset="UTF-8">
    <meta name="viewport"
    content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
    <script src="functii_cos.js" async></script>
    <style>
        body, html {height: 100%}
        body,h1,h2,h3,h4,h5,h6 {font-family: "Animatic SC", sans-serif}
        .menu {display:none}
        .bgimg {
            background-repeat: no-repeat;
            background-size: cover;
            background-image: url("opera.jpg");
            min-height: 90%;
        }
    </style>

    <!-- Bara Meniu-->
    <body>
        <div class="top hide-small">
            <div class="bar xlarge black opacity hover-opacity-off" id="myNavbar">
                <a href="#" class="bar-item button">HOME</a>
                <a href="#menu" class="bar-item button">SPECTACOLE</a>
                <a href="#cart" class="bar-item button">COS</a>
                <a href="#myMap" class="bar-item button">CONTACT</a>
            </div>
        </div>
    </body>
</html>    
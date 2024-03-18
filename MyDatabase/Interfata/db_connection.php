<?php 

$host = 'localhost';
$user = 'root';
$password = '';
$db = 'test';

//Conexiune la server (localhost)
$conn = mysqli_connect(
    $host,
    $user,
    $password);

//Selectare baza de date
$database = mysqli_select_db(
    $conn,
    $db
);


if($conn->connect_error){
    die("Conexiune esuata: ".$conn->connect_error);
}
echo "Conexiune la baza de date reușită!";
?> 
<?php
include 'db_connect.php';

function adaugaComanda($idClient, $idSpectacol, $numarBile) {
    global $conn;
    $sql = "INSERT INTO Comenzi (ID_client, ID_spectacol, Numar_bile) VALUES ('$idClient', '$idSpectacol', '$numarBile')";
    $conn->query($sql);
}
?>

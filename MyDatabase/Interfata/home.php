<?php
// Include database connection
include 'db_connection.php'; // You need to create this file to establish a database connection
$conn = getDbConnection();

// Function to add a new client
function addClient($name, $surname, $address, $email, $phone) {
    global $conn;
    $query = "INSERT INTO Client (Nume, Prenume, Adresa, Email, Telefon) 
              VALUES ('$name', '$surname', '$address', '$email', '$phone')";
    $conn->query($query);
}

// Function to add a new order
function addOrder($clientId, $paymentId, $reservationId, $orderDate) {
    global $conn;
    $query = "INSERT INTO Comenzi (ID_client, ID_plata, ID_rezervare, data_comanda) 
              VALUES ('$clientId', '$paymentId', '$reservationId', '$orderDate')";
    $conn->query($query);
}

// Function to add a new payment
function addPayment($totalPrice) {
    global $conn;
    $query = "INSERT INTO Plata (total_pret) VALUES ('$totalPrice')";
    $conn->query($query);
}

// Function to add a new reservation
function addReservation($spectacleId, $reservationDate) {
    global $conn;
    $query = "INSERT INTO Rezervari (ID_spectacol, data_rezervare) 
              VALUES ('$spectacleId', '$reservationDate')";
    $conn->query($query);
}

// Function to add new seats for a reservation
function addSeats($reservationId, $row, $number, $available) {
    global $conn;
    $query = "INSERT INTO Locuri (ID_rezervare, rand, numar, disponibil) 
              VALUES ('$reservationId', '$row', '$number', '$available')";
    $conn->query($query);
}

// Function to add a new spectacle
function addSpectacle($type, $name, $dateTime) {
    global $conn;
    $query = "INSERT INTO Spectacole (tip_spectacol, Nume, Data_ora) 
              VALUES ('$type', '$name', '$dateTime')";
    $conn->query($query);
}

// Example of usage
// Add a new client
addClient('John', 'Doe', '123 Main St', 'john@example.com', '1234567890');

// Add a new payment
addPayment(150);

// Add a new reservation
addReservation(1, '2024-01-15');

// Add new seats for the reservation
addSeats(1, 1, 2, 1);
addSeats(1, 1, 3, 1);

// Add a new order
addOrder(1, 1, 1, '2024-01-15');
?>

<?php
include 'db_connection.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Preiați datele din formular
    $nume = $_POST["nume"];
    $prenume = $_POST["prenume"];
    $email = $_POST["email"];


    // Validează datele (aici poți adăuga logica pentru constrângeri)
    if (empty($nume) || empty($prenume) || empty($email)) {
        echo "Nume, prenume și email sunt obligatorii.";
    } else {
        // Salvează datele în baza de date
        $query = "INSERT INTO client (nume, prenume, email) VALUES ('$nume', '$prenume', '$email')";
        $result = mysqli_query($conn, $query);

        if ($result) {
            echo "Datele au fost salvate cu succes în baza de date.";
        } else {
            echo "Eroare la salvarea datelor în baza de date: " . mysqli_error($conn);
        }
    }
} else {
    echo "Acces neautorizat!";
}
?>

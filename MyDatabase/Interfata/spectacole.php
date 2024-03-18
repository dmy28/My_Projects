<?php
include 'db_connect.php';

function adaugaSpectacol($nume, $dataOra) {
    global $conn;
    $sql = "INSERT INTO Spectacole (Nume, Data_Ora) VALUES ('$nume', '$dataOra')";
    $conn->query($sql);
}

function getSpectacole() {
    global $conn;
    $sql = "SELECT * FROM Spectacole";
    $result = $conn->query($sql);
    $spectacole = [];
    while ($row = $result->fetch_assoc()) {
        $spectacole[] = $row;
    }
    return $spectacole;
}

if (isset($_POST['button'])) {
    $spectacol_name = $_POST['spectacol-name'];
    $spectacol_price = $_POST['spectacol-price'];

    if (!empty($spectacol_name) && !empty($spectacol_price) && $spectacol_price >= 0) {
        adaugaSpectacol($spectacol_name, $spectacol_price);

        foreach ($_POST as $ing_name => $ing_quantity) {
            if ($ing_quantity > 0) {
                $sql_update = "UPDATE spectacole SET $ing_name = ? WHERE tip_spectacol = ?";
                $stmt_update = $conn->prepare($sql_update);
                $stmt_update->bind_param("ds", $ing_quantity, $spectacol_name);
                $stmt_update->execute();
                $stmt_update->close();
            }
        }

        $conn->commit();
    } else {
        echo "<script>alert('Nume sau pret nevalid')</script>";
    }
}
?>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title></title>
</head>

<body>
    <h3>Adauga un spectacol nou</h3>
    <form class="" action="spectacol.php?refresh=1" method="post">
        <label for="spectacol-name">Nume spectacol</label>
        <input type="text" name="spectacol-name">
        <br>
        <br>
        <label for="spectacol-price">Pret spectacol</label>
        <input type="number" step="0.01" name="spectacol-price">
        <br>
        <h4>Locuri</h4>
        <?php
        $sql = "SELECT * FROM locuri";
        $result = mysqli_query($conn, $sql);

        if (mysqli_num_rows($result) > 0) {
            while ($row = mysqli_fetch_assoc($result)) {
                $name = $row['denumire_ing'];
                echo "<label for='$name'> $name</label><input type='number' name='$name'>
                    <br><br>";
            }
        }
        ?>
        <button type="submit" name="button">Adauga</button>
    </form>
</body>

</html>

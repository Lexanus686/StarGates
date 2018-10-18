<?php
require_once 'connection.php';

$link = mysqli_connect($host, $user, $password, $database)
or die("Error " . mysqli_error($link));

$query = "SELECT * FROM UserTable";
$result = mysqli_query($link, $query) or die("Error " . mysqli_error($link));
if ($result) {
    echo "Выполнение запроса прошло успешно";
}

mysqli_close($link);
?>
<?php

$EMAIL_ID = 745056150;// 9-digit integer value (i.e., 123456789)
$API_KEY = "60cb4998"; // API key (string) provided by Open Movie DataBase (i.e., "ab123456")

session_start(); // Connect to the existing session

require_once '/home/common/php/dbInterface.php'; // Add database functionality
require_once '/home/common/php/mail.php'; // Add email functionality
require_once '/home/common/php/p4Functions.php'; // Add Project 4 base functions

processPageRequest(); // Call the processPageRequest() function

// DO NOT REMOVE OR MODIFY THE CODE OR PLACE YOUR CODE ABOVE THIS LINE


function addMovieToCart($imdbID)
{	
	$movieID = movieExistsInDB($imdbID);

    if($movieID == 0) {

        $result= file_get_contents('http://www.omdbapi.com/?apikey='.$GLOBALS['API_KEY'].'&i='.$imdbID.'&type=movie&r=json');
        $movieInfo = json_decode($result, true);

        $title = $movieInfo['Title'];
        $year = $movieInfo['Year'];
        $rating = $movieInfo['Rated'];
        $runtime = $movieInfo['Runtime'];
        $genre = $movieInfo['Genre'];
        $actors = $movieInfo['Actors'];
        $director = $movieInfo['Director'];
        $writer = $movieInfo['Writer'];
        $plot = $movieInfo['Plot'];
        $poster = $movieInfo['Poster'];

        $movieID = addMovie($imdbID, $title, $year, $rating, $runtime, $genre, $actors, $director, $writer, $plot, $poster);
    }

    $userId = $_SESSION["userId"];
    addMovieToShoppingCart($userId, $movieID);
    displayCart();
    
}

function displayCart()
{
    $userId = $_SESSION["userId"];
	$movies = getMoviesInCart($userId);
    require_once "./templates/cart_form.html";
}

function processPageRequest()
{
	if (!isset($_SESSION["displayName"])) {
        header("Location: logon.php");
        exit();
    }

    if (!isset($_GET["action"])) {
        displayCart();

    } else {
        $action = $_GET["action"];

        if (isset($_GET["imdb_id"]) && $action === "add"){
            addMovieToCart($_GET["imdb_id"]);
            header("Location: index.php");
            exit();

        } elseif (isset($_GET["movie_id"]) && $action === "remove") {
            removeMovieFromCart($_GET["movie_id"]);
            header("Location: index.php");
            exit();
        }

    }
}

function removeMovieFromCart($movieID)
{	
    $userId = $_SESSION["userId"];
    $remove = removeMovieFromShoppingCart($userId, $movieID);
	if ($remove) {
        header("Location: index.php");
        exit();
    }
}

?>
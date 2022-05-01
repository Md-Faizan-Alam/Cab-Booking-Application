<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Trip</title>
<link rel="stylesheet" href="http://localhost:8085/images/cab.css">
<style>
#advert {
	background-color: rgb(26, 26, 26);
	color: white;
	padding: 20px;
	margin: 100px;
	width: 600px;
	font-size: 30px;
	border-radius: 40px;
}

.press {
	background-color: black;
	border: 2px solid white;
	border-radius: 10px;
	padding: 5px 20px;
	font-size: 20px;
	text-decoration: none;
	color: white;
	margin: 10px;
	position: relative;
	left: 300px;
}

.press:hover {
	background-color: rgb(70, 70, 70);
	border: 2px solid black;
}

#buttonContainer {
	position: absolute;
	right: 50px;
	top: 50px;
}

.info {
	background-color: rgb(231, 231, 231);;
	color: black;
	width: 500px;
	border: 1px solid white;
	border-radius: 20px;
	font-size: 24px;
	margin: 20px auto;
	padding: 20px;
	line-height: 50px;
}

#type {
	position: relative;
	left: 200px;
}
#welcome {
	color: white;
	position: absolute;
	right: 30px;
	top: 10px;
	font-size: 25px;
	font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
}
#logout{
    background-color: black;
	border: 2px solid white;
	border-radius: 10px;
	padding: 5px 10px;
	font-size: 20px;
	text-decoration: none;
	color: white;
	position: absolute;
	right: 50px;
    top: 50px;
}
#logout:hover{
    background-color: rgb(70, 70, 70);
}
</style>
</head>
<body>
	<header>
		<a href="/headHome" id="headTitle">Wheelin</a>
		<span id="welcome">Welcome, ${userName}</span>
		<a href="/logout" id="logout">Logout</a>
	</header>
	<div id="advert">
		Your Trip Details :
		<hr>
		<div class="info">
			From : ${trip.getFromLocation()}<br>
			To : ${trip.getToLocation()}<br>
			Date : ${trip.getDate()}<br>
			License No. : ${trip.getDriver().getLicenceNo()} <br>
			Distance : ${trip.getDistanceInKm()} Km<br>
			Bill : Rs ${trip.getBill()}<br>
			Your Cab is on the way<br>
            <form action="/rate" method="post">
                <label for="rating">Rate your driver : </label>
                <input type="radio" name="rating" value="1">&nbsp;
                <input type="radio" name="rating" value="2">&nbsp;
                <input type="radio" name="rating" value="3">&nbsp;
                <input type="radio" name="rating" value="4">&nbsp;
                <input type="radio" name="rating" value="5">&nbsp;
                <br>
                <input type="hidden" name="driverId" value="${trip.getDriver().getUserId()}">
                <button type="submit" class="press">Rate</button>
            </form>
		</div>
	</div>
	<img src="/images/Taxi.jpg" id="taxi" alt="">
	<footer></footer>
</body>
</html>
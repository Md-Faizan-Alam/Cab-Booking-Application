<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Trip</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

header {
	background-color: rgb(26, 26, 26);
	height: 100px;
	display: block;
}

#headTitle {
	font-size: 60px;
	color: white;
	font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
	position: relative;
	width: 100px;
	top: 15px;
	left: 50px;
	display: inline;
}

footer {
	background-color: rgb(26, 26, 26);
	height: 150px;
	color: white;
}

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
</style>
</head>
<body>
	<header>
		<p id="headTitle">Wheelin</p>
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
	<footer></footer>
</body>
</html>
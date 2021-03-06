<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="http://localhost:8085/images/cab.css">
<link rel="stylesheet" href="cab.css">
<style>
#advert {
	background-color: rgb(26, 26, 26);
	color: white;
	padding: 50px 50px 100px;
	margin: 100px;
	width: 600px;
	height: 100px;
	font-size: 45px;
	font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
	border-radius: 40px;
}
.press {
	background-color: black;
	border: 2px solid white;
	border-radius: 10px;
	padding: 10px 20px;
	font-size: 20px;
	text-decoration: none;
	color: white;
	margin: 10px;
}
#buttonContainer {
	position: absolute;
	right: 300px;
	top: 40px;
}
</style>
</head>
<body>
	<header>
		<a href="/headHome" id="headTitle">Wheelin</a>
		<div id="buttonContainer">
			 <a class="press" href="/cabManagement">Cab Management</a>
			<a class="press" href="/bookingManagement">Booking Management</a>
			<a class="press" href="/driverManagement">Driver Management</a>
		</div>
		<span id="welcome">Welcome, ${userName}</span>
		<a href="/logout" id="logout">Logout</a>
	</header>
	<div id="advert">Keep Moving
			<form action="/nextPage" method="post">
				
			</form>
			</div>
	<img src="/images/Taxi.jpg" id="taxi" alt="">
	<footer></footer>
</body>
</html>
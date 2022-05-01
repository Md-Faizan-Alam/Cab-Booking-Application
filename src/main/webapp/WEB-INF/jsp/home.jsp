<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="http://localhost:8085/images/cab.css">
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
	right: 50px;
	top: 40px;
}
#bookLink{
	background-color: black;
	border: 2px solid white;
	border-radius: 10px;
	padding: 5px 10px;
	text-decoration: none;
	color: white;
	font-size: 25px;
    position: relative;
    top: 50px;
    left: 300px;
}
#bookLink:hover{
	background-color: rgb(70, 70, 70);
}
</style>
</head>
<body>
	<header>
		<a href="/headHome" id="headTitle">Wheelin</a>
		<div id="buttonContainer">
			<a class="press" href="/login">Login</a> <a class="press"
				href="/registerCustomer">Register As Customer</a> <a class="press"
				href="/registerDriver">Register As Driver</a>
		</div>
	</header>
	<div id="advert">Keep Moving<br><a href="/login" id="bookLink">Book a Cab</a></div>
    <img src="/images/Taxi.jpg" id="taxi" alt="">
	<footer></footer>
</body>
</html>
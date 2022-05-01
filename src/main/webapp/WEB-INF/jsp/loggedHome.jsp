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
	width: 450px;
	height: 100px;
	font-size: 45px;
	font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
	border-radius: 40px;
}

#buttonContainer {
	position: absolute;
	right: 50px;
	top: 40px;
}
#welcome {
	color: white;
	position: absolute;
	right: 30px;
	top: 10px;
	font-size: 25px;
	font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
}
.press{
    background-color: black;
	border: 2px solid white;
	border-radius: 10px;
	padding: 5px 10px;
	text-decoration: none;
	color: white;
}
.press:hover{
    background-color: rgb(70, 70, 70);
}
#logout{
	font-size: 20px;
	position: absolute;
	right: 50px;
    top: 50px;
}
#bookLink{
	font-size: 25px;
    position: relative;
    top: 50px;
    left: 300px;
}
</style>
</head>
<body>
	<header>
		<a href="/headHome" id="headTitle">Wheelin</a>
		<span id="welcome">Welcome, ${userName}</span>
		<a href="/logout" class="press" id="logout">Logout</a>
	</header>
	<div id="advert">Keep Moving <br><a href="/book"  class="press" id="bookLink">Book a Cab</a></div>
	<img src="/images/Taxi.jpg" id="taxi" alt="">
	<footer></footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
	text-decoration: none;
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
	<footer></footer>
</body>
</html>
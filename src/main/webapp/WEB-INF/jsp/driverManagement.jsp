<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wheelin - ${userName}</title>
<link rel="stylesheet" href="http://localhost:8085/images/cab.css">
<link rel="stylesheet" href="cab.css">

<style>
#advert {
	background-color: rgb(26, 26, 26);
	color: white;
	padding: 50px;
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
	left: 350px;
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
	background-color: rgb(231, 231, 231);
	color: black;
	width: 500px;
	border-radius: 20px;
	font-size: 24px;
	margin: 20px auto;
	padding: 20px;
	line-height: 50px;
}
#best{
    background-color: rgb(186 255 222);
	color: black;
	width: 500px;
    border: 5px solid #00a3ff;
	border-radius: 20px;
	font-size: 24px;
	margin: 20px auto;
	padding: 20px;
	line-height: 50px;
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
		<hr>
                <div id="best">
                    Best Drivers : <br>
                    <c:forEach items="${bestDrivers}" var="driver">
                        ${driver.getUsername()} : ${driver.getRating()}<br>
                    </c:forEach>
                </div>
        <hr>
	</div>
	<img src="/images/Taxi.jpg" id="taxi" alt="">
	<footer></footer>
</body>
</html>
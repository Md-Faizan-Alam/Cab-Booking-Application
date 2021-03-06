<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome - ${userName}</title>
<link rel="stylesheet" href="http://localhost:8085/images/cab.css">
<style>
#advert {
	background-color: rgb(26, 26, 26);
	color: white;
	padding: 50px 20px;
	margin: 100px;
	width: 900px;
	height: auto;
	font-size: 30px;
	border-radius: 40px;
}

.press {
	background-color: white;
	border: 2px solid white;
	border-radius: 10px;
	padding: 5px 50px;
	font-size: 20px;
	text-decoration: none;
	color: black;
	margin: 10px;
}

#confirm {
	background-color: black;
	border: 2px solid white;
	border-radius: 10px;
	padding: 5px 20px;
	font-size: 25px;
	text-decoration: none;
	color: white;
	position: relative;
	left: 400px;
}

#confirm:hover {
	background-color: rgb(70, 70, 70);
}

#buttonContainer {
	position: absolute;
	right: 50px;
	top: 50px;
}

#type {
	position: relative;
	left: 10px;
	background-color: black;
	color: white;
	border: 1px solid white;
	border-radius: 8px;
	padding: 5px;
	font-size: 15px;
	margin: 10px;
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
		<form action="/customerLog" method="post">
			<label for="fromLocation">From:</label> <select id="fromLocation"
				class="press" name="fromLocation">
				<c:forEach items="${locationList}" var="location">
					<option value="${location.getName()}">${location.getName()}</option>
				</c:forEach>
			</select> <label for="toLocation">To:</label> <select id="toLocation"
				class="press" name="toLocation">
				<c:forEach items="${locationList}" var="location">
					<option value="${location.getName()}">${location.getName()}</option>
				</c:forEach>
			</select><br>
			<br> <label for="type">Car Type : </label> <select id="type"
				name="carType">
				<option value="All">All</option>
				<option value="Sedan">Sedan</option>
				<option value="Mini">Mini</option>
				<option value="Share">Share</option>
				<option value="InterCity">InterCity</option>
				<option value="Prime">Prime</option>
			</select>
			<button type="submit" id="confirm">Next</button>
		</form>
	</div>
	<footer></footer>
</body>
</html>
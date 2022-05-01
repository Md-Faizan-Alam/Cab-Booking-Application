<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wheelin - ${userName}</title>
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
	padding: 30px;
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
		Total Cabs :
		<hr>
		<c:forEach items="${cabList}" var="cab">
			<form action="/confirm" method="post">
				<div class="info">
					Total Cabs : ${cab.getAllCabs()}<br>
					
					 <input type="hidden" name="cabId"
						value="${cab.getCabId()}"> 
					<button type="submit" class="press">Insert New Cab</button> <br>
					<button type="submit" class="press">Delete a Cab</button><br>
					<button type="submit" class="press">Update a Cab</button>
				</div>
			</form>
		</c:forEach>
	</div>
	<footer></footer>
</body>
</html>
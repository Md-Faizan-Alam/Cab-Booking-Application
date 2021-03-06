<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="http://localhost:8085/images/cab.css">
<link rel="stylesheet" href="cab.css">
<style>
#loginBlock {
	background-color: rgb(26, 26, 26);
	margin: 100px;
	display: inline-block;
	color: white;
	font-size: 20px;
	border-radius: 40px;
	padding: 30px 50px;
	font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
}

input {
	height: 20px;
	border-radius: 10px;
	border: 0px;
	padding: 5px 15px;
	margin: 10px 0px;
	font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
}

#login {
	background-color: rgb(26, 26, 26);
	border: 2px solid white;
	color: white;
	font-size: 20px;
	text-align: center;
	height: 35px;
	padding: 0px 20px;
	margin: 30px 0px;
	position: relative;
	left: 200px;
}

#login:hover {
	background-color: rgb(39, 39, 39);
	border: 1px solid rgb(100, 100, 100);
}

#type {
	position: relative;
	right: 10px;
	background-color: black;
	color: white;
	border: 1px solid white;
	border-radius: 8px;
	padding: 5px;
	font-size: 15px;
	margin: 10px;
}
.message{
        color: #ff1818;
        font-size: 15px;
    }
</style>
</head>
<body>
	<header>
		<a href="/headHome" id="headTitle">Wheelin</a>
	</header>
	<div id="loginBlock">
        <span class="message">${message}</span><br>
		<form action="/saveCustomer" method="post">
			<label for="userName">Enter a Username: &nbsp;</label> <input
				type="text" name="userName" id="" placeholder="Username"><br>
			<label for="address">Enter your Address: &nbsp;</label> <input
				type="text" name="address" id="" placeholder="Address"><br>
			<label for="mobileNumber">Enter your mobile number: &nbsp;</label> <input
				type="text" name="mobileNumber" id="" placeholder="MobileNumber"><br>
			<label for="email">Enter your Email: &nbsp;</label> <input
				type="email" name="email" id="" placeholder="Email"><br>
			<label for="password">Enter a Password: &nbsp;</label> <input
				type="password" name="password1" id="" placeholder="Password"><br>
			<label for="password">Confirm Password: &nbsp;</label> <input
				type="password" name="password2" id="" placeholder="Password"><br>
			<input type="submit" id="login" value="Register">

		</form>
	</div>
	    <img src="/images/Taxi.jpg" id="taxi" alt="">
	<footer></footer>
</body>
</html>
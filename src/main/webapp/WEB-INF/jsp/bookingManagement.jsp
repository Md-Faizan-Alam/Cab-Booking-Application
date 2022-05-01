<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
#bookLink{
	font-size: 25px;
    position: relative;
    top: 50px;
    left: 300px;
}
#loginBlock{
        background-color: rgb(26, 26, 26);
        margin: 150px 200px;
        display: inline-block;
        color: white;
        font-size: 20px;
        border-radius: 40px;
        padding: 50px 50px;
        font-family: 'Gill Sans', 'Gill Sans MT','Trebuchet MS', sans-serif;
    }
    input{
        height: 20px;
        width: 200px;
        border-radius: 10px;
        border: 0px;
        padding: 10px 15px;
        margin: 10px 0px;
        font-family: 'Gill Sans', 'Gill Sans MT','Trebuchet MS', sans-serif;
    }
    #login{
        background-color: rgb(26, 26, 26);
        border: 2px solid white;
        color: white;
        font-size: 20px;
        text-align: center;
        height: 35px;
        width: 100px;
        padding: 0px 20px;
        margin: 30px 0px;
        position: relative;
        left: 20px;
    }
    #login:hover{
        background-color: rgb(39, 39, 39);
        border: 1px solid rgb(100, 100, 100);
    }
    #type{
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
    .register{
        color: white;
        font-size: 15px;
        display: inline-block;
        width: 260px;
        text-align: center;
        text-decoration: none;
    }
    .register:hover{
        text-decoration: underline;
    }
</style>
</head>
<body>
	<header>
		<a href="/headHome" id="headTitle">Wheelin</a>
		<span id="welcome">Welcome, ${userName}</span>
		<a href="/logout" class="press" id="logout">Logout</a>
	</header>
	<div id="loginBlock"><form action="/search" method="post">
        <select name="type" id="type">
            <option value="CA">CarType</option>
            <option value="CU">Customer</option>
            <option value="DR">Driver</option>
        </select><br>
        <input type="text" name="keyword" id="" placeholder="Search">
        <input type="submit" id="login" value="Search"><br>
    </form></div>
	<img src="/images/Taxi.jpg" id="taxi" alt="">
	<footer></footer>
</body>
</html>
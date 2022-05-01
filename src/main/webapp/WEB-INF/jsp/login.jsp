<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib
	uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs"
	prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="http://localhost:8085/images/cab.css">
<style>
    #loginBlock{
        background-color: rgb(26, 26, 26);
        margin: 100px;
        display: inline-block;
        color: white;
        font-size: 20px;
        border-radius: 40px;
        padding: 10px 50px;
        font-family: 'Gill Sans', 'Gill Sans MT','Trebuchet MS', sans-serif;
    }
    input{
        height: 20px;
        border-radius: 10px;
        border: 0px;
        padding: 5px 15px;
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
        padding: 0px 20px;
        margin: 30px 0px;
        position: relative;
        left: 150px;
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
    .message{
        color: #ff1818;
        font-size: 15px;
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
<header><a href="/headHome" id="headTitle">Wheelin</a></header>
<div id="loginBlock"><form action="/sign" method="post">
    <span class="message">${message}</span><br>
    <select name="type" id="type">
        <option value="A">Admin</option>
        <option value="C">Customer</option>
        <option value="D">Driver</option>
    </select><br>
    <label for="userName">Username: &nbsp;</label>
    <input type="text" name="userName" id="" placeholder="Username"><br>
    <label for="password">Password: &nbsp;</label>
    <input type="password" name="password" id="" placeholder="Password"><br>
    <input type="submit" id="login" value="Login"><br>
    <a href="/registerCustomer" class="register">New here? Register</a><br>
    <a href="/registerDriver" class="register">or Register as a driver</a>
</form></div>
    <img src="/images/Taxi.jpg" id="taxi" alt="">
<footer></footer>
</body>
</html>
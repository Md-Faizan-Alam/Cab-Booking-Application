<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
    *{
        margin: 0px;
        padding: 0px;
    }
    header{
        background-color: rgb(26, 26, 26);
        height: 100px;
        display: block;
    }
    #headTitle{
        font-size: 60px;
        color: white;
        font-family: 'Gill Sans', 'Gill Sans MT','Trebuchet MS', sans-serif;
        position: relative;
        width: 100px;
        top: 15px;
        left: 50px;
        display: inline;
    }
    footer{
        background-color: rgb(26, 26, 26);
        height: 150px;
        color: white;
    }
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
</style>
</head>
<body>
<header><p id="headTitle">Wheelin</p></header>
<div id="loginBlock">
<form action="/sign" method="post">
    <select name="type" id="type" >
        <option value="A">Admin</option>
        <option value="C">Customer</option>
        <option value="D">Driver</option>
    </select><br>
    <label for="userName">Username: &nbsp;</label>
    <input type="text" name="userName" placeholder="Username or Email"><br>
    <label for="password">Password: &nbsp;</label>
    <input type="password" name="password" placeholder="Password"><br>
    <input type="submit" id="login" value="Login">
</form>
</div>
<footer></footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wheelin - Username</title>
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
    #advert{
        background-color: rgb(26, 26, 26);
        color: white;
        padding: 30px;
        margin: 100px;
        width: 600px;
        font-size: 30px;
        border-radius: 40px;
    }
    .press{
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
    .press:hover{
        background-color: rgb(70, 70, 70);
        border: 2px solid black;
    }
    #buttonContainer{
        position: absolute;
        right: 50px;
        top: 50px;
    }
    .info{
        background-color: rgb(231 231 231);
        color: black;
        width: 500px;
        border-radius: 20px;
        font-size: 24px;
        margin: 20px auto;
        padding: 20px;
        line-height: 50px;
    }
    #type{
        position: relative;
        left: 200px;
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
    <p id="headTitle">Wheelin</p>
</header>
<div id="advert">
    Available Cabs :
    <select id="type" name="carType">
    <option value="All">All</option>
    <option value="Sedan">Sedan</option>
    <option value="Mini">Mini</option>
    <option value="Share">Share</option>
    <option value="InterCity">InterCity</option>
    <option value="Prime">Prime</option>
    </select>
    <hr>
    <c:forEach items="${cabList}" var="cab">
    <div class="info">
        Type : ${cab.getCarType()}<br>
        Rate : ${cab.getPerKmRate()}<br>
        <a href="/book" class="press">Book</a>
    </div>
    </c:forEach>
</div>
<footer></footer>
</body>
</html>
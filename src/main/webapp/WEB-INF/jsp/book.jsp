<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
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
        padding: 50px;
        margin: 100px;
        width: 800px;
        height: 150px;
        font-size: 30px;
        border-radius: 40px;
    }
    .press{
        background-color: white;
        border: 2px solid white;
        border-radius: 10px;
        padding: 5px 50px;
        font-size: 20px;
        text-decoration: none;
        color: black;
        margin: 10px;
    }
    #confirm{
        background-color: black;
        border: 2px solid white;
        border-radius: 10px;
        padding: 10px 20px;
        font-size: 20px;
        text-decoration: none;
        color: white;
        position: relative;
        top: 50px;
        left: 380px;
    }
    #confirm:hover{
        background-color: rgb(70, 70, 70);
    }
    #buttonContainer{
        position: absolute;
        right: 50px;
        top: 50px;
    }
</style>
</head>
<body>
<header>
    <p id="headTitle">Wheelin</p>
</header>
<div id="advert">

    <label for="fromLocation">From:</label>
    <select id="fromLocation" class="press" name="fromLocation">
    	<c:forEach items="${locationList}" var="location" >
        <option value="${location.getName()}">${location.getName()}</option>
    	</c:forEach>
    </select>

    <label for="toLocation">To:</label>
    <select id="toLocation" class="press" name="toLocation">
        <c:forEach items="${locationList}" var="location" >
        <option value="${location.getName()}">${location.getName()}</option>
    	</c:forEach>
    </select><br>

    <a href="" id="confirm">Confirm Booking</a>
    </div>
<footer></footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wheelin - ${customer.getUsername()}</title>
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
</style>
</head>
<body>
<header>
    <p id="headTitle">Wheelin</p>
</header>
<div id="advert">
    Available Cabs :
    <hr>
    <c:forEach items="${driverList}" var="driver">
        <form action="/confirm" method="post">
            <div class="info">
                Type : ${driver.getCab().getCarType()}<br>
                Rate : ${driver.getCab().getPerKmRate()}<br>
                Rating : ${driver.getRating()}<br>
                <input type="hidden" name="driverId" value="${driver.getUserId()}">
                <input type="hidden" name="fromLocation" value="${fromLocation}">
                <input type="hidden" name="toLocation" value="${toLocation}">
                <button type="submit" class="press">Book</button>
            </div>
        </form>
    </c:forEach>
</div>
<footer></footer>
</body>
</html>
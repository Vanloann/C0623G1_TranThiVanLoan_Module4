<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<hr>
<form>
    <input type="checkbox" id="con1" name="condiment" value="Lettuce">
    <label for="con1">Lettuce</label><br>
    <input type="checkbox" id="con2" name="condiment" value="Tomato">
    <label for="con2">Tomato</label><br>
    <input type="checkbox" id="con3" name="condiment" value="Mustard">
    <label for="con3">Mustard</label><br>
    <input type="checkbox" id="con4" name="condiment" value="Sprouts">
    <label for="con4">Sprouts</label><br>
    <input type="submit" value="Submit">
</form>

<p>Your choice:</p>
<c:forEach items="${condiment}" var="con">
    <p>${con}</p>
</c:forEach>
</body>
</html>
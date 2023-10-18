<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

</head>
<body>
<h1>Dictionary</h1>
<br/>
<form action="dic">
    <input type="text" name="word" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
    <p>${word}</p>
</form>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Currency Converted</h1>
<br/>
<form action="/convert">
    <label for="VND">Quantity</label>
    <input type="number" name="vnd" id="VND" value=""> VND
    <input type="number" name="usd" id="USD" value="${usd}"> USD
    <button type="submit">Convert</button>
</form>
</body>
</html>
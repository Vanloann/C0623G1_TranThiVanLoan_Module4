<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<br/>
<form action="calculate" method="post">
    <input type="number" name="firstOperator">
    <input type="number" name="secondOperator"><br/><br/>
    <button type="submit" name="operator" value="Add">Addition(+)</button>
    <button type="submit" name="operator" value="Sub">Subtraction(-)</button>
    <button type="submit" name="operator" value="Multi">Multiplication(x)</button>
    <button type="submit" name="operator" value="Div">Division(/)</button>
</form>

<p>Result: ${result}</p>

</body>
</html>
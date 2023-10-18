<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/12/2023
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">

</head>
<body>


<h2>Customer Information</h2>

<form action="/customers" method="post">
    <fieldset>
        <legend>Detail:</legend>
        <table>
            <tr>
<%--                <th><label for="id">Id:</label></th>--%>
                <td>
                    <input type="hidden" id="id" name="id" value="${customer.id}">
                </td>
            </tr>
            <tr>
                <th><label for="name">Customer name:</label></th>
                <td>
                    <input type="text" id="name" name="name" value="${customer.name}">
                </td>
            </tr>
            <tr>
                <th><label for="email">Email:</label></th>
                <td>
                    <input type="email" id="email" name="email" value="${customer.email}">
                </td>
            </tr>
            <tr>
                <th><label for="address">Address:</label></th>
                <td>
                    <input type="text" id="address" name="address" value="${customer.address}">
                </td>
            </tr>
            <tr>
                <th><input type="submit" value="Update"></th>
            </tr>
        </table>
    </fieldset>
</form>


<a href="/customers">Back to list</a>

</body>
</html>

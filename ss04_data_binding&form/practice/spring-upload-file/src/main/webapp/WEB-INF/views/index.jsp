<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h3>Product Management</h3>
<table id = "products">
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="product : ${products}">
        <td th:text="${product.name}"></td>
        <td th:text="${product.description}"></td>
        <td><img width="100" height="100" th:src="@{'/image/' + ${product.image}}" alt="" src=""></td>
    </tr>
    </tbody>
</table>
<p>
    <a th:href="@{/create}">
        Add new product
    </a>
</p>
</body>
</html>
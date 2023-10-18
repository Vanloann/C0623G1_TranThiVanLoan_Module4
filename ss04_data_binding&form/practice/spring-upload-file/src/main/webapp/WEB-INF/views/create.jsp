<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/16/2023
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
</head>
<body>
<h3>Add Product</h3>
<p>
    <a th:href="@{}">
        Back to product list
    </a>
</p>
<div id="form">
    <form th:action="@{/save}" th:object="${productForm}"
          method="POST" novalidate="novalidate" enctype="multipart/form-data">
        <input type="hidden" th:field="*{id}"/>
        <table>
            <tr>
                <td><label for="name">Name</label></td>
                <td><input type="text" id="name" th:field="*{name}"/></td>
            </tr>
            <tr>
                <td><label for="description">Description</label></td>
                <td><input type="text" id="description" th:field="*{description}"/></td>
            </tr>
            <tr>
                <td><label for="image">Image</label></td>
                <td><input type="file" id="image" th:field="*{image}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

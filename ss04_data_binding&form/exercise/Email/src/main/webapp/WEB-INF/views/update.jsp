<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Email</h1>
<table>
    <tr>
        <th>Languages</th>
        <td>${emails.languages}</td>
    </tr>
    <tr>
        <th>Page Size</th>
        <td>${emails.pageSize}</td>
    </tr>
    <tr>
        <th>Spams Filter</th>
        <td><input
        <c:if test="${emails.spamsFilter == 'true'}">
                checked
        </c:if>
                 type="checkbox" value="${emails.spamsFilter}"></td>
    </tr>
    <tr>
        <th>Signature</th>
        <td>
            <textarea>${emails.signature}</textarea>
        </td>
    </tr>
</table>
</body>
</html>
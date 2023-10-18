<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/update" modelAttribute="email">
    <table>
<%--        <c:forEach items="${emailList}" var="email">--%>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <th>Languages</th>
            <td>
                <form:select path="languages" value="${emails.languages}">
                    <form:options items="${languagesList}" />
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page Size</th>
            <td>
                <form:select path="pageSize" value="${emails.pageSize}">
                    <span>Show </span>
                    <form:options items="${pages}" /> <span> emails per page</span>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Spams Filter</th>
            <td><form:checkbox path="spamsFilter" label="Enable spams filter" value="${emails.spamsFilter}"/></td>
        </tr>
        <tr>
            <th>Signature</th>
            <td>
                <form:textarea path="signature" value="${emails.signature}"/>
            </td>
        </tr>
<%--        </c:forEach>--%>
        <tr>
            <td>
                <button type="submit">Update</button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
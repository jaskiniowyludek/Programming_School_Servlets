<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 10/11/18
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solutions</title>
</head>
<body>
<%@include file="fragments/header.jsp"%>
    <h3>Exercise's title: </h3>
    <p>${exercise.title}</p>
    <h3>Exercise's description:</h3>
    <p>${exercise.description}</p>
    <h3>All solutions added: </h3>
    <table border="3">
        <th>SOLUTION ID</th>
        <th>SOLUTION UPDATED</th>
        <th>SOLUTION DESCRIPTION</th>
        <th>USER</th>
        <c:forEach items="${solutions}" var="solution">
            <tr>
                <td>${solution.id}</td>
                <td>${solution.updated}</td>
                <td>${solution.description}</td>
                <td><a href="/users?id=${solution.user_id}">${solution.username}</a> </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
<%--Strona	musi	wyświetlać	treść	zadania	oraz	wszystkie	jego	rozwiązania	wraz	--%>
<%--danymi	użytkownika,	który--%>
<%--je	dodał.--%>
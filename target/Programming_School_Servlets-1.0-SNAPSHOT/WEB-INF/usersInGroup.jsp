<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 10/11/18
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users in this group</title>
</head>
<body>
<%@include file="fragments/header.jsp"%>
<h2>Users in this group:</h2>
    <table border="3">
        <th>LOGIN</th>
        <th>EMAIL</th>
        <c:forEach items="users" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><a href="/userDetails?id=${user.id}">Details</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
<%--Ta	strona	ma	wyświetlać	listę	wszystkich	użytkowników	--%>
<%--należących	do	danej	grupy	z	możliwością--%>
<%--przejścia	do	strony	danego	użytkownika.--%>
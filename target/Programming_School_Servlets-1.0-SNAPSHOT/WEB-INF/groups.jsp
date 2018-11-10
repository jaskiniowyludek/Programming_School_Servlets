<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 10/11/18
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
</head>
<body>
<%@include file="fragments/header.jsp"%>
    <h2>See all groups:</h2>
    <table border="3">
        <th>NAME</th>
        <th>USERS IN THIS GROUP</th>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>${group.name}</td>
                <td><a href="/users?id=${group.id}">Click!</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
<%--Strona	ma	wyświetlać	listę	wszystkich	grup	z	możliwością	przejścia	--%>
<%--do	użytkowników	danej	grupy.--%>
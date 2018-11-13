<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 13/11/18
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<%@include file="../fragments/headerAdmin.jsp"%>
<p>
    <a href="/panelAdmin/addUser">Add new user</a>
</p>
<h2>See all users:</h2>
<table border="3">
    <th>USERNAME</th>
    <th>EMAIL</th>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td><a href="/panelAdmin/editUser?id=${user.id}">Edit</a></td>
            <td><a href="/panelAdmin/deleteUser?id=${user.id}"
                   onclick="return confirm('Are you sure you want to delete this user?');">Delete</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

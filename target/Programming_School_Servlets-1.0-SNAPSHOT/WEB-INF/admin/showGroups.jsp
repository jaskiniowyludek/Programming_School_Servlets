<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 12/11/18
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All groups</title>
</head>
<body>
<%@include file="../fragments/headerAdmin.jsp"%>
<div>
    <a href="/WEB-INF/admin/groupForm.jsp">Add new group</a>
</div>
    <h2>See all groups:</h2>
    <table border="3">
        <th>NAME</th>
        <th>USERS IN THIS GROUP</th>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>${group.name}</td>
                <td><a href="/users?id=${group.id}">Click!</a> </td>
                <td><a href="/panelAdmin/editGroup?id=${group.id}">Edit</a></td>
                <td><a href="/panelAdmin/deleteGroup?id=${group.id}"
                       onclick="return confirm('Are you sure you want to delete this group?');">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

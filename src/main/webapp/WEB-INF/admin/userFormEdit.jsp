<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 13/11/18
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<%@include file="../fragments/headerAdmin.jsp"%>
<h2>User form:</h2>
<form action="/panelAdmin/editUser" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <div>Username:
        <input type="text" name="userName" value="${user.username}">
    </div>
    <div>Password:
        <input type="text" name="password" value="${user.password}">
    </div>
    <div>Email:
        <input type="email" name="email" value="${user.email}">
    </div>
    <div>User group: ${user.user_group}
        <input type="radio" name="userGroup" value="${user.user_group}" checked>
    </div>
    <div>Select group:
        <c:forEach items="${groups}" var="group">
            <input type="radio" name="userGroup" value="${group.id}">${group.id}
        </c:forEach>
    </div>
    <input type="submit" value="Save">
</form>
</body>
</html>

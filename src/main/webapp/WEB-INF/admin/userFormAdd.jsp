<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 13/11/18
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
    <%@include file="../fragments/headerAdmin.jsp"%>
    <h2>User form:</h2>
    <form action="/panelAdmin/addUser" method="post">
        <div>Username:
        <input type="text" name="userName" placeholder="Type username">
        </div>
        <div>Password:
        <input type="text" name="password" placeholder="Type password">
        </div>
        <div>Email:
        <input type="email" name="email" placeholder="Type email">
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

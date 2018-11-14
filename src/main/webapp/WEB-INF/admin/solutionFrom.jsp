<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 14/11/18
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new exercise for a user</title>
</head>
<body>
<form method="post" action="/panelAdmin/addSolution">
    <input type="hidden" name="userId" value="${user.id}">
    <div>Select exercises you want to add to this user: </div>
    <c:forEach items="${exercises}" var="exercise">
        ${exercise.title}
        <input type="radio" name="solution" value="${exercise.id}">
    </c:forEach>
    <input type="submit" value="Save">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 15/11/18
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add solution</title>
</head>
<body>
<%@include file="fragments/header.jsp"%>
    <form method="post" action="/addSolutionToExercise">
        <input type="hidden" name="id" value="${solution.id}">
        <div>Add solution:
        <input type="textarea" cols="30" rows="10" name="description">
        </div>
        <input type="submit" value="Save">
    </form>
</body>
</html>

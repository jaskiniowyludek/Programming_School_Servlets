<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 13/11/18
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit exercise</title>
</head>
<body>
    <%@include file="../fragments/headerAdmin.jsp"%>
    <h2>Exercise edit form:</h2>
    <form method="post" action="/panelAdmin/editExercise">
        <input type="hidden" name="id" value="${exercise.id}">
        <div>
            Title:
            <input type="text" name="title" value="${exercise.title}">
        </div>
        <div>
            Description:
            <input type="text" name="description" value="${exercise.description}">
        </div>
        <input type="submit" value="Save">
    </form>
</body>
</html>

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
    <title>Add new exercise</title>
</head>
<body>
    <%@include file="../fragments/headerAdmin.jsp"%>
    <h2>Exercise form:</h2>
    <form method="post" action="/panelAdmin/addExercise">
        <div>
            Title:
            <input type="text" name="title" placeholder="Type title">
        </div>
        <div>
            Description:
            <input type="text" name="description" placeholder="Type description">
        </div>
        <input type="submit" value="Save">
    </form>
</body>
</html>

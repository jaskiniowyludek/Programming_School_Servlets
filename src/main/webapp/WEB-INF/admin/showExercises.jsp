<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 13/11/18
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All exercises</title>
</head>
<body>
<%@include file="../fragments/headerAdmin.jsp"%>
<p>
    <a href="/panelAdmin/addExercise">Add new exercise</a>
</p>
<h2>See all exercises:</h2>
<table border="3">
    <th>TITLE</th>
    <th>DESCRIPTION</th>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.title}</td>
            <td>${exercise.description}</td>
            <td><a href="/panelAdmin/editExercise?id=${exercise.id}">Edit</a></td>
            <td><a href="/panelAdmin/deleteExercise?id=${exercise.id}"
                   onclick="return confirm('Are you sure you want to delete this exercise?');">Delete</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

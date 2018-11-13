<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 9/11/18
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
<%@include file="fragments/header.jsp"%>
    <h2>
    THE NEWEST SOLUTIONS ADDED
    </h2>
<table border="5">
    <tr>
        <th>ID</th>
        <th>EXERCISE'S TITLE</th>
        <th>AUTHOR</th>
        <th>CREATED</th>
        <th>UPDATED</th>
        <th>DESCRIPTION</th>
    </tr>
        <c:forEach items="${solutions}" var="solution">
            <tr>
            <td>${solution.id}</td>
            <td>${solution.exerciseTitle}</td>
            <td>${solution.username}</td>
            <td>${solution.created}</td>
            <td>${solution.updated}</td>
            <td>${solution.description}</td>
            <td><a href="/solution?id=${solution.exercise_id}">Details</a> </td>
            </tr>
        </c:forEach>

</table>
</body>
</html>

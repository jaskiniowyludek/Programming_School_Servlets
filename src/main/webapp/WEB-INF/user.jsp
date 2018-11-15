<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 10/11/18
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User's details</title>
</head>
<body>
<%@include file="fragments/header.jsp"%>
<h2>User's details:</h2>
<ul>
    <li>ID: ${user.id}</li>
    <li>Login: ${user.username}</li>
    <li>Email: ${user.email}</li>
</ul>

<h2>Exercises assigned to this user: </h2>
<ul>
    <li>
    <c:forEach items="${solutions}" var="solution">
        <ol>
            <li><a href="/addSolutionToExercise?id=${solution.id}">Add solution to this exercise</a> </li>
            <li>Exercise title: ${solution.exerciseTitle}</li>
            <li>Exercise created: ${solution.created}</li>
            <li>Solution added: ${solution.updated}</li>
            <li>Solution: ${solution.description}</li>
        </ol>
    </c:forEach>
    </li>
</ul>

</body>
</html>
<%--Strona	ma	wyświetlać	wszystkie	dane,	jakie	mamy	na	temat	użytkownika.--%>
<%--Wszystkie	dodane	przez	niego	rozwiązania	zadań	w	kolejności	od	najnowszych.--%>
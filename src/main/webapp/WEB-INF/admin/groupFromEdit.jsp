<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 13/11/18
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit group</title>
</head>
<body>
    <%@include file="../fragments/headerAdmin.jsp"%>
    <h2>Group form:</h2>
    <form action="/panelAdmin/editGroup" method="post">
        <input type="hidden" name="id" value="${group.id}">
        <div>
            Group name:
        </div>
        <input type="text" name="groupName" value="${group.name}">
        <input type="submit" value="Save">
    </form>
</body>
</html>

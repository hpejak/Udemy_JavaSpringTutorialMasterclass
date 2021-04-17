<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hr.pejak.learning.spring.todo.utill.Mappings" %>
<html  lang="en-us">
<head>
    <title>Todo Application</title>
</head>
<body>
    <div align="center">
        <c:url var="itemsLink" value="${Mappings.ITEMS}" />
        <h2><a href="${itemsLink}">Show ToDo Items</a> </h2>
    </div>
</body>
</html>

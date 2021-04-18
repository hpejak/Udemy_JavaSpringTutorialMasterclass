<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hr.pejak.learning.spring.todo.utill.Mappings" %>
<html  lang="en-us">
<head>
    <title>Todo Items</title>
</head>
<body>
    <div align="center">
        <c:url var="addUrl" value="${Mappings.ADD_ITEM}" />
        <h2><a href="${addUrl}">New Item</a> </h2>

        <table border="1" cellpadding="5">
            <caption><h2>Todo Items</h2></caption>
            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="item" items="${toDoData.items}">

                <c:url var="viewUrl" value="${Mappings.VIEW_ITEM}" >
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="editUrl" value="${Mappings.ADD_ITEM}" >
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}" >
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <tr>
                    <td><c:out value="${item.title}" /></td>
                    <td><c:out value="${item.deadline}" /></td>
                    <td><a href="${viewUrl}">View Item</a></td>
                    <td><a href="${editUrl}">Edit Item</a></td>
                    <td><a href="${deleteUrl}">Delete Item</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

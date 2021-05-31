<%--
  Created by IntelliJ IDEA.
  User: 112
  Date: 24/05/2021
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Name</th><th>Author</th><th>Price</th><th>Update</th><th>Delete</th></tr>
    <c:forEach var="book" items="${list}">
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td><a href="book-edit/${book.id}">Update</a></td>
            <td><a href="book-delete/${book.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="book-add">Add New Book</a>
</body>
</html>

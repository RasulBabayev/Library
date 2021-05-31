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
    <tr><th>Id</th><th>Name</th><th>Surname</th><th>Update</th><th>Delete</th></tr>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td><a href="updateuser/${user.id}">Update</a></td>
            <td><a href="deleteuser/${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="register">Add New Employee</a>
</body>
</html>

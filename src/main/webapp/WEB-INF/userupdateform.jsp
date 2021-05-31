<%--
  Created by IntelliJ IDEA.
  User: 112
  Date: 24/05/2021
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Employee</h1>
<f:form method="post" action="/updateuser" modelAttribute= "user">
    <table >
        <tr>
            <td></td>
            <td><f:input  path="id" type="hidden" name="id" /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><f:input  path="name" type="text" name="name"  /></td>
        </tr>
        <tr>
            <td>Surname :</td>
            <td><f:input  path="surname" type="text" name="surname" /></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><f:input  path="email" type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><f:input  path="password" type="password" name="password" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" name= "update" value="Update" /></td>
        </tr>
    </table>
</f:form>
</body>
</html>

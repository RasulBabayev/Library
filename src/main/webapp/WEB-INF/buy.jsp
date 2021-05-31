<%--
  Created by IntelliJ IDEA.
  User: 112
  Date: 31/05/2021
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Are you sure?</title>
</head>
<body>
<div class="container">
    <f:form method="post" action="/buy-book" modelAttribute="book">
        <h3>Do you want to buy this book ?</h3>
        <f:input path="id" type="hidden" name="id"/>
        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="/books" class="btn btn-danger" role="button" >Cancel</a>
    </f:form>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Author</th>
        <th scope="col">Price</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${book}" var="book">
        <tr>
            <td scope="row">${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>


        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>

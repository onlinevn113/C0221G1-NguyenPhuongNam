<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/28/2021
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<h1>Student List</h1>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Email</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${students}" var ="student" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.email}</td>
            <td><a href="student?action=edit&id=${student.id}">Edit</a></td>
            <td><a href="student?action=delete&id=${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>

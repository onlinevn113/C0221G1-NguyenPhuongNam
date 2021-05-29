<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/28/2021
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>

<p>
    <a href="/product?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name Product</td>
        <td>Price</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td><a href="/product?action=view&id=${p.getId()}">${p.getId()}</a></td>
            <td> ${p.getName()} </td>
            <td> ${p.getPrice()} </td>
            <td><a href="/product?action=edit&id=${p.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${p.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

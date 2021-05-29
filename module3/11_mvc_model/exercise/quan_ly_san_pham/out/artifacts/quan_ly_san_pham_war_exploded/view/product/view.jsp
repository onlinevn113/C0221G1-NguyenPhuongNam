<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/29/2021
  Time: 5:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product detail</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table>
    <tr>
        <td>Id: </td>
        <td>"${product}".getId</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>"${product}".getName</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>"${product}".getPrice</td>
    </tr>
</table>
</body>
</html>

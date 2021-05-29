
<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/29/2021
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product ${nameS}</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<c:forEach var="p" items="${products}">
    <table border="1">
        <tr>
            <td>Id: ${p.getId()}</td>
        </tr>
        <tr>
            <td>Name: ${p.getName()}</td>
        </tr>
        <tr>
            <td>Price: ${p.getPrice()}</td>
        </tr>
    </table>

</c:forEach>
</body>
</html>

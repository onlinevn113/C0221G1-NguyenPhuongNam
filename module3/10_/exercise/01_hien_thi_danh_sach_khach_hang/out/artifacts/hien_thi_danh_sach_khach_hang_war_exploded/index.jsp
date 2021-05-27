<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/27/2021
  Time: 8:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
  <head>
    <title>$Title$</title>

  </head>
  <body>

 <div>
     <h2>Danh sách khách hàng</h2>
    <table border="1px">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer1" items="${customer}">
            <tr>
                <td>${customer1.name}</td>
                <td>${customer1.dayOfBirth}</td>
                <td>${customer1.address}</td>
                <td><img height="100px" src="${customer1.picture}" alt=""></td>
            </tr>
        </c:forEach>
    </table>
 </div>

  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/26/2021
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <style>

  </style>
  <h2>Product Discount Calculator</h2>
  <form action="/display-discount" method="get">
    <p class="llll">Product Description: </p>
    <input type="text" name="product">
    <p>List Price: </p>
    <input type="text" name="price">
    <p>Discount Percent: </p>
    <input type="text" name="discount" placeholder="%"> <br><br>
    <input type="submit" value="Calculate Discount">
  </form>






  <script src="../_bootstrap-4.6.0-dist/Jquery/jquery-3.6.0.min.js"></script>
  <script src="../_bootstrap-4.6.0-dist/js/bootstrap.js"></script>
  </body>
</html>

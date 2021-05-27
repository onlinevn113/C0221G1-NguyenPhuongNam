<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/27/2021
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="calculator"  style="border: 1px solid; width: 300px" method="get">
    <p>Calculator</p>
    First operand: <input type="number" name="firstNum"><br><br>
    Operator:
    <select name="operator" id="">
      <option value="+">Additon</option>
      <option value="-">Subtraction</option>
      <option value="*">Division</option>
      <option value="/">Multiplication</option>
    </select><br><br>
    Second operand: <input type="number" name="secondNum"><br><br>
    <input type="submit" value="Caculate">
  </form>
  </body>
</html>

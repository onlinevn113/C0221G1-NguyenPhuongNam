<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/26/2021
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
double first = Double.parseDouble(request.getParameter("first"));
double second = Double.parseDouble(request.getParameter("second"));
double sum = first+ second;
RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
request.setAttribute("sum1",sum);
requestDispatcher.forward(request,response);
%>
</body>
</html>

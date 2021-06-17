<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 6/17/2021
  Time: 6:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form method="post" action="/update" modelAttribute="setting">
    <table>
        <tr>
            <td><b>Languages:</b></td>
            <td><form:select path="language" cssStyle="width: 300px">
                <form:option value="English">English</form:option>
                <form:option value="VietNamese">Vietnamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><b>Page Size:</b></td>
            <td>
                <form:select path="pagesize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100 ">100</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><b>Spam filter:</b></td>
            <td><form:checkbox path="spamFilter" value="${true}"/></td>
        </tr>
        <tr>
            <td><b>Signature:</b></td>
            <td><form:textarea path="signature" rows="4" cols="40"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update" style="background: deepskyblue"></td>
            <td><a href="/setting"><input type="button" value="Cancel"></a></td>
        </tr>
    </table>
</form:form>
</body>
</html>

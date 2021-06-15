<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../bootraps_min/bootstrap.min.css">
</head>
<body>
<div class="container-fluid -3 mb-3 d-flex align-items-center justify-content-between"
     style="background: #085F56;height: 60px">
    <div><img src="../../img/FURAMA.png" height="60" width="60"/></div>
    <div class="d-flex justify-content-around " style="width: 100%">
        <a href="/view/home/home.jsp" style="color: white">Home</a>
        <a href="/employees" style="color: white">Employee</a>
        <a href="/customers" style="color: white">Customer</a>
        <a href="/services" style="color: white">Service</a>
        <a href="/contracts?action=create" style="color: white">Contract</a>
        <a href="/details?action=create" style="color: white">Contract Detail</a>
    </div>
</div>
<div class="container-fluid d-flex justify-content-center">
    <h1>Edit customer</h1>
</div>
<div>
    <c:if test="${message != null}">
        <p class="text-success">${message}</p>
    </c:if>
</div>
<div class="container d-flex ">
    <form action="/customers?action=edit" style="width: 70%;margin-left: 155px" method="post">
        <div class="form-group row">
            <label for="inputId" class="col-sm-3 col-form-label">ID</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inputId" name="id" readonly value="${customer.id}">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputCode" class="col-sm-3 col-form-label">Customer Code</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inputCode" name="code" value="${customer.code}">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputName" class="col-sm-3 col-form-label">Customer Name</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inputName" name="name" value="${customer.name}">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputType" class="col-sm-3 col-form-label">Type of customer</label>
            <div class="col-sm-6">
                <select name="type" id="inputType" value="customer.customerTypeName">
                    <c:forEach items="${list}" var="type">
                        <c:choose>
                            <c:when test="${type[1] == customer.customerTypeName}">
                                <option value="${type[0]}" selected>${type[1]}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${type[0]}">${type[1]}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="inputDate" class="col-sm-3 col-form-label">Date</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" id="inputDate" name="date" value="${customer.birthday}">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputGender" class="col-sm-3 col-form-label">Gender</label>
            <div class="col-sm-6">
                <select name="gender" id="inputGender">
                    <c:forEach items="${listGender}" var="listGender">
                        <c:choose>
                            <c:when test="${customer.gender == listGender}">
                                <option value="${listGender}" selected>${listGender}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${listGender}">${listGender}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="inputEmail" class="col-sm-3 col-form-label">Email</label>
            <div class="col-sm-6">
                <input type="email" class="form-control" id="inputEmail" name="email" value="${customer.email}">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputIdCard" class="col-sm-3 col-form-label">Id card</label>
            <div class="col-sm-6">
                <input type="number" class="form-control" id="inputIdCard" name="idCard" value="${customer.idCard}">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPhone" class="col-sm-3 col-form-label">Phone</label>
            <div class="col-sm-6">
                <input type="number" class="form-control" id="inputPhone" name="phone" value="${customer.phone}">
            </div>
        </div>

        <div class="form-group row">
            <label for="inpurAddress" class="col-sm-3 col-form-label">Address</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inpurAddress" name="address" value="${customer.address}">
            </div>
        </div>
        <div class="d-flex ">
            <a href="/customers" class="btn btn-secondary" style="margin-left: 200px">Back to list</a>
            <input type="submit" class="btn btn-success" style="margin-left: 174px;width: 100px" value="Edit">
        </div>

    </form>
</div>

<script src="../../bootraps_min/jquery-3.6.0.min.js"></script>
<script src="../../bootraps_min/popper.min.js"></script>
<script src="../../bootraps_min/bootstrap.min.js"></script>
</body>
</html>

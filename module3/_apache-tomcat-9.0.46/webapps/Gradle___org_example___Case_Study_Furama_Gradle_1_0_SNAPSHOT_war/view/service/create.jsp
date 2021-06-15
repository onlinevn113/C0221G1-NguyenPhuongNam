<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/3/2021
  Time: 6:35 PM
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
    <div><img src="img/FURAMA.png" height="60" width="60"/></div>
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
    <h1>Add New Service</h1>
</div>
<div>
    <c:if test="${message != null}">
        <h4>${message}</h4>
    </c:if>
</div>
<div class="container d-flex ">
    <form action="/services?action=create" style="width: 70%;margin-left: 155px" method="post">

        <div class="form-group row">
            <label  class="col-sm-3 col-form-label">Type Service Name</label>
            <div class="col-sm-6">
                <select name="typeService" onchange="changeCreate(this.value)" >
                    <c:forEach items="${typeServices}" var="typeService">
                        <option value="${typeService.id}">${typeService.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="inputName" class="col-sm-3 col-form-label">Service Name</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inputName" name="name">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputDate" class="col-sm-3 col-form-label">Area</label>
            <div class="col-sm-6">
                <input type="number" class="form-control" id="inputDate" name="area">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputGender" class="col-sm-3 col-form-label">Cost</label>
            <div class="col-sm-6">
                <input type="number" class="form-control" id="inputGender" name="cost">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputIdCard" class="col-sm-3 col-form-label">Max people</label>
            <div class="col-sm-6">
                <input type="number" class="form-control" id="inputIdCard" name="peopleMax">
            </div>
        </div>
        <div class="form-group row">
            <label  class="col-sm-3 col-form-label">Type of rent</label>
            <div class="col-sm-6">
                <select name="rentTypeService" >
                    <c:forEach items="${rentTypes}" var="rentType">
                        <option value="${rentType.id}">${rentType.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div id="divStandardRoom">
            <div class="form-group row" >
                <label for="inputEmail" class="col-sm-3 col-form-label">Standard room</label>
                <div class="col-sm-6">
                    <input type="email" class="form-control" id="inputEmail" name="standardRoom">
                </div>
            </div>
        </div>
        <div id="divDescription">
            <div class="form-group row" >
                <label for="inputType" class="col-sm-3 col-form-label">Description</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="inputType" name="description">
                </div>
            </div>
        </div>
        <div id="divPoolArea">
            <div class="form-group row" >
                <label for="inputPool" class="col-sm-3 col-form-label">Pool area</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="inputPool" name="poolArea">
                </div>
            </div>
        </div>
        <div id="divNumberFloor">
            <div class="form-group row" >
                <label for="inpurfloor" class="col-sm-3 col-form-label">Number of floor</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="inpurfloor" name="numberFloor">
                </div>
            </div>
        </div>
        <div class="d-flex ">
            <a href="/services" class="btn btn-secondary " style="margin-left: 200px">Back to list</a>
            <input type="submit" class="btn btn-success" style="margin-left: 174px;width: 100px" value="Create">
        </div>

    </form>
</div>
<script src="../../bootraps_min/jquery-3.6.0.min.js"></script>
<script src="../../bootraps_min/popper.min.js"></script>
<script src="../../bootraps_min/bootstrap.min.js"></script>

<script>
    function changeCreate(value) {
        document.getElementById("divStandardRoom").style.display = "block";
        document.getElementById("divDescription").style.display = "block";
        document.getElementById("divNumberFloor").style.display = "block";
        document.getElementById("divPoolArea").style.display = "block";
        if (value == 2){
            document.getElementById("divPoolArea").style.display = "none";
        }
        if (value==3){
            document.getElementById("divStandardRoom").style.display = "none";
            document.getElementById("divDescription").style.display = "none";
            document.getElementById("divNumberFloor").style.display = "none";
            document.getElementById("divPoolArea").style.display = "none";

        }

    }
</script>
</body>
</html>

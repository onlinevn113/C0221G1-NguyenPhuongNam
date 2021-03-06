<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/30/2021
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    <script src="../bootstrap/jquery.dataTables.min.js"></script>
    <script src="../bootstrap/dataTables.bootstrap4.min.js"></script>

    <title>Edit Student</title>
    <style>
        #footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            z-index: 3;
        }
        .msg{
            color: red;
        }
        #nav-bar-sticky {
            position: -webkit-sticky;
            position: sticky;
            top: 0;
            z-index: 2;
        }
    </style>
</head>
<body>
<div class="container-fluid d-flex position-relative border-0 row   ">
    <div class="col-3 ">
        <a href="" class="img-fluid"><img class=" img-fluid mx-5"
                                          src="../img/logo_furama/logo_furama.png"
                                          height="117" width="87"/></a>
    </div>
    <div class="col-3">
        <a class=" img-fluid mx-5 px-5 align-items-center img-fluid"
           href="https://www.tripadvisor.com/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang.html">
            <img
                    class="img-fluid  " src="../img/logo_tripadvisor/logo_tripadvisor.png"
            /></a>
    </div>
    <div class="col-6 text-right"><span>Nguyễn Phương Nam</span>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark  container-fluid font-weight-bolder px-0 text-white" id="nav-bar-sticky"
     style=" height: 47px;background: #0F574B">

    <div class="collapse navbar-collapse  " id="navbarsExample07">
        <ul class="navbar-nav mr-auto">


            <li class="nav-item active px-5">
                <a class="text-white" href="/home.jsp">Home</a>
            </li>


            <li class="nav-item active px-5">
                <a class="text-white" href="/student">Student</a>
            </li>


            <%--            <li class="nav-item active px-5">--%>
            <%--                <a class="text-white" href="/employee">Employee</a>--%>
            <%--            </li>--%>


            <%--            <li class="nav-item active px-5">--%>
            <%--                <a class="text-white" href="/service">Service</a>--%>
            <%--            </li>--%>

            <%--            <li class="nav-item active px-5">--%>
            <%--                <a class="text-white" href="/contract">Contract</a>--%>
            <%--            </li>--%>
        </ul>



        <form method="post" action="/student?action=search" class="form-inline pt-3 mr-1  align-items-end"
              style="position: relative">
            <div class="pl-5">
                <input class="form-control " type="search" placeholder="Search" aria-label="Search" name="nameS">
                <button type="submit" class="rounded-circle">
                    <img class="img-fluid rounded-circle" style="height: 32px;"
                         src="https://static.vecteezy.com/system/resources/previews/001/504/972/original/search-icon-free-vector.jpg"
                         alt="">
                </button>
            </div>
        </form>

    </div>
</nav>


<div class="container-fluid d-flex " style="background: #e6faf8">
    <div class="col-2"> Item
        <c:if test="${message!=null}">
            <p class="text-primary">${message}</p>
        </c:if>
        <p class="text-center p-3 row" style="font-family: 'Comic Sans MS',cursive;font-weight: bold;font-size: 20px">
            <button><a href="/student" methods="get">Back to list customer</a></button>
        </p>
    </div>

    <div class="col-8">
        <span style="font-family: 'Comic Sans MS',cursive;font-weight: bold;font-size: 20px">EDIT CUSTOMER</span>
        <form action="/student?action=edit&id=${student.id}" method="post"
              class="container border border-dark mb-3 pt-3">
<%--            <div class="form-group">--%>
<%--                <label> Customer Type : </label>--%>
<%--                <select class="form-control" name="customerTypeId">--%>
<%--                    <c:forEach var="type" items="${customerTypes}">--%>
<%--                        <option value="${type.idTypeCustomer}" ${type.idTypeCustomer==customerFail.idTypeCustomer?"selected":""}>${type.customerTypeName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
            <div class="form-group">
                <label>ID:</label>
                <input type="text" class="form-control" value="${student.id}" disabled>
            </div>

            <div class="form-group">
                <label>Name:</label>
                <input type="text" class="form-control" name="name" value="${student.name}">
                <p class="msg">${nameMsg}</p>
            </div>

            <div class="form-group">
                <label>Gender: </label>
                <select class="form-select form-control " name="gender">
                    <c:if test="${student.gender == 1}">
                        <option value="1" selected>Nữ</option>
                        <option value="0">Nam</option>
                    </c:if>
                    <c:if test="${student.gender == 0}">
                        <option value="1">Nữ</option>
                        <option value="0" selected>Nam</option>
                    </c:if>
                </select>
                <p class="msg">${genderMsg}</p>
            </div>
            <div class="form-group">
                <label>Birthday:</label>
                <input type="date" class="form-control" name="birthday" value="${student.birthday}">
                <p class="msg">${birthdayMsg}</p>
            </div>

            <div class="form-group">
                <label>Email: </label>
                <input type="email" class="form-control" name="email" value="${student.email}">
                <p class="msg">${emailMsg}</p>
            </div>
            <div class="form-group">
                <label>Address: </label>
                <input type="text" class="form-control" name="address" value="${student.address}">
                <p class="msg">${addressMsg}</p>
            </div>

            <div class="d-flex justify-content-center ">
                <button type="submit" class="btn btn-primary mb-3">Update</button>
            </div>
        </form>

    </div>


    <div class="col-2"> Item
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    </div>
</div>









<footer class="text-white ">
    <div class="container px-4 pb-3 text-center">
        <section class="mb-3">
            <span style="color: black">For more infomation@ </span>
            <a target="_blank" class="m-1 rounded-circle"
               href="https://www.facebook.com/furamaresort/"
               role="button">
                <img src="../img/icon/facebook.png"
                     class="img-fluid rounded-circle" style="height: 40px; width: 40px" alt="">
            </a>
            <a class="m-1 rounded-circle"
               href="https://www.instagram.com/furama_resort_danang/?hl=vi"
               role="button">
                <img src="../../img/icon/283-2831746_insta-icon-instagram.png"
                     class="img-fluid rounded-circle" style="height: 30px; width: 30px" alt="">
            </a>
        </section>
    </div>

    <div class="text-center px-2 justify-content-center align-items-center " id="footer" style=" background: #0F574B">
        <span>COVID 19 UPDATE: The safety and well-being are our utmost priority</span>
        <a href="https://furamavietnam.com/covid-19-update/">
            <%--            <input class="my-1" type="button" value="Learn more" style="background: #c1f8f0; border-radius: 5px;height: 25px">--%>
            <button class="my-1" style="background: #c1f8f0; border-radius: 5px; height: 25px">Learn more</button>
        </a>
    </div>
</footer>
<div class="row container-fluid"></div>
<script src="../bootstrap/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap/jquery.dataTables.min.js"></script>
<script src="../../bootstrap/dataTables.bootstrap4.min.js"></script>
<script src="bootstrap/popper.min.js"></script>
<script src="../bootstrap/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10,

        });
    });
</script>
</body>
</html>

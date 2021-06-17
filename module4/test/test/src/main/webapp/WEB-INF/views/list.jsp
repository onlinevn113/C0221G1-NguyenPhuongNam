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
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="stylesheet" href="../../../resources/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../../../resources/bootstrap/dataTables.bootstrap.min.css">
    <script src="../../../resources/bootstrap/popper.min.js"></script>
    <script src="../../../resources/bootstrap/jquery-3.6.0.min.js"></script>
    <script src="../../../resources/bootstrap/jquery.dataTables.min.js"></script>
    <script src="../../../resources/bootstrap/dataTables.bootstrap4.min.js"></script>
    <script src="../../../resources/bootstrap/bootstrap.min.js"></script>


    <style>
        #footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            z-index: 3;
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
                <a class="text-white" href="/customer">Customer</a>
            </li>


            <li class="nav-item active px-5">
                <a class="text-white" href="/employee">Employee</a>
            </li>


            <li class="nav-item active px-5">
                <a class="text-white" href="/service">Service</a>
            </li>

            <li class="nav-item active px-5">
                <a class="text-white" href="/contract">Contract</a>
            </li>
        </ul>



        <form method="post" action="/customer?action=search" class="form-inline pt-3 mr-1  align-items-end"
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
    <div class="col-2">
        <c:if test="${message!=null}">
            <p class="text-primary">${message}</p>
        </c:if>
    </div>

    <div class="col-8">
        <p class="text-center p-3 row" style="font-family: 'Comic Sans MS',cursive;font-weight: bold;font-size: 20px">
            LIST CUSTOMER</p>
        <p class="text-center p-3 row" style="font-family: 'Comic Sans MS',cursive;font-weight: bold;font-size: 20px">
            <button><a href="/customer?action=create" methods="get">
                Create Customer
            </a></button>
        </p>
         <table id="tableCustomer" class="table table-bordered table-striped ">
            <thead>
            <tr>
                <th>STT</th>
                <th>Customer Type</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customers}" var="customer" varStatus="a">
                <tr>
                    <td>${a.count}</td>
                    <c:forEach var="type" items="${customerTypes}">
                        <c:if test="${type.idTypeCustomer == customer.idTypeCustomer}">
                            <td>${type.customerTypeName}</td>
                        </c:if>
                    </c:forEach>
                    <td>${customer.name}</td>
                    <td>${customer.dateOfBirth}</td>
                    <td>
                            ${customer.sex==1?"Male":"Female"}
                    </td>
                        <%--                    <td>--%>
                        <%--                    <c:if test="${customer.sex==1}">--%>
                        <%--                        Male--%>
                        <%--                    </c:if>--%>
                        <%--                    <c:if test="${customer.sex==0}">--%>
                        <%--                        FeMale--%>
                        <%--                    </c:if>--%>
                        <%--                    </td>--%>
                        <%--                    --%>
                    <td >
                        <a href="/customer?action=edit&id=${customer.idCustomer}">
                            <button type="button" class="btn btn-primary">Edit</button>
                        </a>
                    </td>
                    <td>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                                onclick="myFunction(${customer.idCustomer})">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-2">
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    </div>

</div>

<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/customer?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myModalLabel">Accept delete customer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete this customer???
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger btn-ok" id="delete" value="Delete">
                    <input type="hidden" id="idCustomer" name="idCustomer">
                </div>
            </div>
        </form>

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


<%--<script src="/resources/bootstrap/bootstrap.min.js"></script>--%>
<%--<script src="/resources/bootstrap/jquery-3.6.0.min.js"></script>--%>
<%--<script src="/resources/bootstrap/jquery.dataTables.min.js"></script>--%>
<%--<script src="/resources/bootstrap/dataTables.bootstrap4.min.js"></script>--%>
<%--<script src="/resources/bootstrap/popper.min.js"></script>--%>


<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10,

        });
    });
</script>

<script type="text/javascript">
    function myFunction(id) {
        document.getElementById("idCustomer").value = id;
    }
</script>

</body>
</html>

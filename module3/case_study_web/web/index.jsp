<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/29/2021
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama Resort</title>
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <style>
        /*#footer {*/
        /*    position: fixed;*/
        /*    bottom: 0;*/
        /*}*/
        #nav-bar-sticky{
            position: -webkit-sticky;
            position: sticky;
            top: 0;
            background-color: yellow;
        }

    </style>
</head>
<body>

1 logo-top
<div class="container-fluid d-flex position-relative border-0">

    <a href="" class="col-2 img-fluid"><img class=" img-fluid mx-5" src="../img/logo_furama/logo_furama.png"
                                            height="117" width="87"/></a>
    <a class="col-3 img-fluid mx-5 px-5 align-items-center"
       href="https://www.tripadvisor.com/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang.html"> <img
            class="img-fluid ounded float-right " src="../img/logo_tripadvisor/logo_tripadvisor.png" height="100"
            width="230"/></a>
    <div class="col-6 text-right item "> Nguyễn Văn A
    </div>
</div>
2 nav-bar
<nav class="navbar navbar-expand-lg navbar-dark  container-fluid font-weight-bolder " id="nav-bar-sticky"
     style=" background: #0F574B">
    <div class="collapse navbar-collapse px-5 " id="navbarsExample07">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active px-5">
                <a class="nav-link" href="#">HOME <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown px-5">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown1" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">EMPLOYEE</a>
                <div class="dropdown-menu" aria-labelledby="dropdown07">
                    <a class="dropdown-item" href="">Action</a>
                    <a class="dropdown-item" href="">Another action</a>
                    <a class="dropdown-item" href="">Something else here</a>
                </div>
            </li>
            <li class="nav-item dropdown px-5">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown2" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">CUSTOMER</a>
                <div class="dropdown-menu" aria-labelledby="dropdown07">
                    <a class="dropdown-item" href="">Action</a>
                    <a class="dropdown-item" href="">Another action</a>
                    <a class="dropdown-item" href="">Something else here</a>
                </div>
            </li>
            <li class="nav-item dropdown px-5">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown3" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">SERVICE</a>
                <div class="dropdown-menu" aria-labelledby="dropdown07">
                    <a class="dropdown-item" href="">Action</a>
                    <a class="dropdown-item" href="">Another action</a>
                    <a class="dropdown-item" href="">Something else here</a>
                </div>
            </li>

            <li class="nav-item active px-5">
                <a class="nav-link" href="#">CONTRACT </a>
            </li>

        </ul>
        <form class="form-inline my-2 my-md-0">
            <input class="form-control" type="text" placeholder="Search" aria-label="Search">
        </form>
    </div>

</nav>
3 body
<div class="card-body container-fluid d-flex  ">
    <div class="col-3 bg-success"> ádasd ad</div>
    <div class="col-9  bg-primary"> ád ad</div>

</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
4 footer

<footer class="bg-light text-center text-white position-fixed">
    <div class="container p-4 pb-0">
        <section class="mb-4">
            <a class="btn btn-floating m-1 rounded-circle"
               href="#!"
               role="button">
                <img src="../img/icon/facebook.png"
                     class="img-fluid rounded-circle" style="height: 40px; width: 40px" alt="">
            </a>
            <a class="btn btn-floating m-1 rounded-circle"
               href="#!"
               role="button">
                <img src="../img/icon/Gmail.png"
                     class="img-fluid rounded-circle" style="height: 40px; width: 40px" alt="">
            </a>
        </section>
    </div>

    <div class="text-center p-2 justify-content-center align-items-center " id="footer" style=" background: #0F574B">
        <b>COVID 19 UPDATE: The safety and well-being are our utmost priority</b>
        <a href="https://furamavietnam.com/covid-19-update/"><input type="submit" value="Learn more" style="background: #7caba3">
        </a>
    </div>
</footer>





<script src="../bootstrap/jquery-3.6.0.min.js"></script>
<script src="bootstrap/popper.min.js"></script>
<script src="../bootstrap/bootstrap.min.js"></script>







</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Phương Nam
  Date: 5/30/2021
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>   <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <title>Update Customer</title>
    <style>
    #footer {
    position: fixed;
    bottom: 0;
    width: 100%;
    }

    #nav-bar-sticky {
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    }

    </style>
    </head>
    <body>

    1 logo-top
    <div class="container-fluid d-flex position-relative border-0 row   ">
    <div class="col-3 ">
    <a href="" class="img-fluid"><img class=" img-fluid mx-5"
    src="../img/logo_furama/logo_furama.png"
    height="117" width="87"/></a>
    </div>
    <div class="col-3">
    <a class=" img-fluid mx-5 px-5 align-items-center img-fluid"
    href="https://www.tripadvisor.com/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang.html"> <img
    class="img-fluid  " src="../img/logo_tripadvisor/logo_tripadvisor.png"
    /></a>
    </div>
    <div class="col-6 text-right "> Nguyễn Văn A
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
    <li class="nav-item active px-5">
    <a class="nav-link" href="#">EMPLOYEE <span class="sr-only">(current)</span></a>
    </li>
    <li class="nav-item active px-5">
    <a class="nav-link" href="#">CUSTOMER <span class="sr-only">(current)</span></a>
    </li>
    <li class="nav-item active px-5">
    <a class="nav-link" href="#">SERVICE <span class="sr-only">(current)</span></a>
    </li>

    <li class="nav-item active px-5">
    <a class="nav-link" href="#">CONTRACT </a>
    </li>


    </ul>
    <form class="form-inline  align-items-end" style="position: relative">
    <div>
    <input class="form-control " type="search" placeholder="Search" aria-label="Search">
    <button type="submit" class="rounded-circle">
    <img class="img-fluid rounded-circle" style="height: 32px;"
    src="https://static.vecteezy.com/system/resources/previews/001/504/972/original/search-icon-free-vector.jpg"
    alt="">
    </button>
    </div>


    </form>
    </div>

    </nav>
    3 body
    <div class="container-fluid d-flex " style="background: #e6faf8">
    <div class="col-2" > Item
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

    </div>

    <div class="col-10">
    <p class="text-center p-3">Update Customer</p>
    <form action="/customer"></form>

    </div>

    </div>


    4 footer

    <footer class=" text-center text-white">
    <div class="container p-4 pb-0">
    <section class="mb-4">
    <a target="_blank" class="btn btn-floating m-1 rounded-circle"
    href="https://www.facebook.com/furamaresort/"
    role="button">
    <img src="../img/icon/facebook.png"
    class="img-fluid rounded-circle" style="height: 40px; width: 40px" alt="">
    </a>
    <a class="btn btn-floating m-1 rounded-circle"
    href="https://www.instagram.com/furama_resort_danang/?hl=vi"
    role="button">
    <img src=""
    class="img-fluid rounded-circle" style="height: 40px; width: 40px" alt="">
    </a>
    </section>
    </div>

    <div class="text-center p-2 justify-content-center align-items-center " id="footer" style=" background: #0F574B">
    <b>COVID 19 UPDATE: The safety and well-being are our utmost priority</b>
    <a href="https://furamavietnam.com/covid-19-update/"><input type="submit" value="Learn more"
    style="background: #7caba3">
    </a>
    </div>
    </footer>
    <script src="../bootstrap/jquery-3.6.0.min.js"></script>
    <script src="bootstrap/popper.min.js"></script>
    <script src="../bootstrap/bootstrap.min.js"></script>
</body>
</html>

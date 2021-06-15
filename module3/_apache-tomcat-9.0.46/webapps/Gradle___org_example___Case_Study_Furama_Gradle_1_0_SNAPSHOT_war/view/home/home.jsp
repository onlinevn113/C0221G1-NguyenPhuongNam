<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../bootraps_min/bootstrap.min.css">
<html>
<head>
    <title>Title</title>
</head>
<body >
<div class="container-fluid align-items-center justify-content-between d-flex" style="background: #085F56;height: 60px">
    <div class=""><img src="../../img/FURAMA.png" height="60" width="60"/></div>
    <p  class="mr-4" style="color: white;font-size: larger">Đặng Anh Toàn</p>
</div>

<!--navbar-->
<div class="container-fluid -3 my-3 d-flex align-items-center justify-content-between" style="background: #085F56;height: 50px">

    <div class="d-flex justify-content-around " style="width: 100%">
        <a href="/view/home/home.jsp" style="color: white">Home</a>
        <a href="/employees" style="color: white">Employee</a>
        <a href="/customers" style="color: white">Customer</a>
        <a href="/services" style="color: white">Service</a>
        <a href="/contracts?action=create" style="color: white">Contract</a>
        <a href="/details?action=create" style="color: white">Contract Detail</a>
    </div>


</div>
<!--content-->
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3 d-flex justify-content-center align-items-center">
            <p style="color: #CBBE73;font-size: 30px"><b>KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ
                KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM.</b></p>
        </div>
        <div class="col-lg-6">
            <div>
                <iframe width="600" height="400" src="https://www.youtube.com/embed/IjlT_4mvd-c"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
            </div>
        </div>
        <div class="col-lg-3">
            <p>Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn hoá
                thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70 căn biệt
                thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo phong cách thiết kế
                truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng danh giá
                nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách, ngôi sao
                điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.

            </p>
        </div>
    </div>
</div>

<p style="color: #CBBE73;font-size: 30px" class="d-flex justify-content-center my-4"><b>CÁC LOẠI PHÒNG</b></p>

<div class="d-flex justify-content-center">
    <p style="width: 50%">Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết hợp với phong cách Pháp, 2
        tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những khu vườn nhiệt đới xanh tươi mát. Ngoài
        ra, khu nghỉ dưỡng Furama còn cung cấp các liệu pháp spa, phòng xông hơi ướt, phòng xông hơi khô, dịch vụ
        mát-xa cạnh hồ bơi, các dịch vụ thể thao dưới nước và các lớp tập yoga và Thái Cực Quyền trên bãi
        biển.</p>
</div>

<div class="d-flex justify-content-center my-3">
    <a href="#" style="color: #0c5460">VIEW ALL ROOMS</a>
</div>

<div class="d-flex justify-content-center">
    <img src="../../img/Vietnam_Danang_Furama_Resort_Exterior_Courtyard-1.jpg" height="509" width="1200"/>
</div>
<!--footer-->
<div class="container-fluid  d-flex justify-content-center align-items-center bg-danger" style="clear: bottom">
    <p>Gmail:danganhtoan1809@gmail.com</p>
</div>



<script src="../../bootraps_min/jquery-3.6.0.min.js"></script>
<script src="../../bootraps_min/popper.min.js"></script>
<script src="../../bootraps_min/bootstrap.min.js"></script>
</body>
</html>

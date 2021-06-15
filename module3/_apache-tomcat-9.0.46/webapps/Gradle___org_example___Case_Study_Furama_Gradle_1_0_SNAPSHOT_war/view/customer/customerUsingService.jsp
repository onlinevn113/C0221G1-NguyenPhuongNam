<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="../../bootraps_min/bootstrap.min.css">
    <link rel="stylesheet" href="../../bootraps_min/dataTables.bootstrap.min.css">
</head>
<body>
<div class="container-fluid align-items-center justify-content-between d-flex mb-3"
     style="background: #085F56;height: 60px">
    <div class=""><img src="../../img/FURAMA.png" height="60" width="60"/></div>
    <h1 class="d-flex justify-content-center text-white">Customer Using Service</h1>
    <p class="mr-4" style="color: white;font-size: larger">Đặng Anh Toàn</p>
</div>

<div class="container-fluid -3 mb-3 d-flex align-items-center justify-content-between"
     style="background: #085F56;height: 60px">
    <div class="d-flex justify-content-around " style="width: 100%">
        <a href="/view/home/home.jsp" style="color: white">Home</a>
        <a href="/employees" style="color: white">Employee</a>
        <a href="/customers" style="color: white">Customer</a>
        <a href="/services" style="color: white">Service</a>
        <a href="/contracts?action=create" style="color: white">Contract</a>
        <a href="/details?action=create" style="color: white">Contract Detail</a>
    </div>
</div>


<div class="d-flex justify-content-end my-3">
    <form action="/customerUsingServices?action=search" class="form-inline my-2 my-lg-0 d-flex" method="post">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" name="searchName">
        <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>

<!--content body-->
<div class="container-fluid">
    <div class="row">
        <table  id="tableCustomer" class="table table-striped table-bordered" style="width: 100%">
            <thead>
            <tr>
                <th scope="col">Customer Id</th>
                <th scope="col">Customer Name</th>
                <th scope="col">Customer Phone</th>
                <th scope="col">Contract Id</th>
                <th scope="col">Start Date</th>
                <th scope="col">End Date</th>
                <th scope="col">ServiceName</th>
                <th scope="col">Show Attach Service</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lists}" var="list">
                <tr>
                    <th scope="row">${list.customerId}</th>
                    <td>${list.customerName}</td>
                    <td>${list.customerPhone}</td>
                    <td>${list.contractId}</td>
                    <td>${list.contractStartDate}</td>
                    <td>${list.contractEndDate}</td>
                    <td>${list.serviceName}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Attach Service
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <c:forEach items="${attachs}" var="attach">
                                    <c:if test="${attach.contractId == list.contractId}">
                                        <p class="dropdown-item" >${attach.attachServiceName}-Số lượng : ${attach.quantity}</p>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </td>
                    <td><a class="btn btn-warning" href="/contracts?action=edit&id=${list.contractId}">Edit</a></td>
                    <td>
                        <button type="button"  class="btn btn-danger buttonDelete" data-toggle="modal"
                                data-target="#exampleModal" onclick="deleteContract('${list.contractId}')">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<!-- Modal delete -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/contracts?action=delete" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete contract</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete this contract?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                    <input type="hidden" id="idDelete" name="contractId">
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../../bootraps_min/jquery-3.6.0.min.js"></script>
<script src="../../bootraps_min/jquery.dataTables.min.js"></script>
<script src="../../bootraps_min/dataTables.bootstrap4.min.js"></script>
<script src="../../bootraps_min/popper.min.js"></script>
<script src="../../bootraps_min/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,

        });
    });
    function deleteContract(id) {
        document.getElementById("idDelete").value = id;
    }

</script>

</body>
</html>

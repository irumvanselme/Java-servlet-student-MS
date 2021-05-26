<%--
  Created by IntelliJ IDEA.
  User: anselme
  Date: 2021-05-25
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light vh-100 pt-5">
<div class="container">
    <a href="index.jsp">Student Management system</a>
    <div class="card card-body mt-5">
        <div class="d-flex justify-content-between align-baseline">
            <h1 class="font-weight-bolder">Student # ${student.id}</h1>
            <div>
                <div>
                    <a href="all-students">All students</a>
                </div>
            </div>
        </div>

        <div class="card card-body mt-5 shadow">
            <div class="row row-cols-2 mx-0 align-baseline">
                <div class="col font-weight-bold mt-2">id </div><div class="col"> ${student.id} </div>
                <div class="col font-weight-bold mt-2">First name</div><div class="col"> ${student.firstName} </div>
                <div class="col font-weight-bold mt-2">Last name</div><div class="col"> ${student.lastName} </div>
                <div class="col font-weight-bold mt-2">Email</div><div class="col"> ${student.email} </div>
                <div class="col font-weight-bold mt-2">Gender</div><div class="col"> ${student.gender} </div>
                <div class="col font-weight-bold mt-2">Year</div><div class="col"> ${student.year} </div>
                <div class="col font-weight-bold mt-2">Class</div><div class="col"> ${student.className} </div>
            </div>

            <div class="d-flex justify-content-between px-3 mt-5">
                <a href="edit-student?id=${student.id}" class="btn btn-info px-3">EDIT</a>
                <a href="students?action=DELETE&id=${student.id}" class="btn btn-danger px-3">DELETE</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

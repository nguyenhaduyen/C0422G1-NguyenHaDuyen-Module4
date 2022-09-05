<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/17/2022
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<p style="text-align: center">Tờ khai y tế</p>
<p style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
    THIẾT ĐỀ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</p>
<P style="text-align: center; color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị
    xử lý hình sự</P>
<form:form action="/save" method="post" modelAttribute="paperDeclaration" class="shadow w-50 container">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Họ Tên</label>
        <form:input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" path="name"/>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Năm sinh</label>
        <form:select class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                     path="yearOfBirth" items="${yearOfBirthList}"/>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Giới Tính</label>
        <form:select class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                     path="gender" items="${genderList}"/>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Quốc Tịch</label>
        <form:select class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                     path="nation" items="${nationList}"/>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Số hộ chiếu hoặc CMND hoặc giấy thông hành hợp pháp
            khác</label>
        <form:input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                    path="identify"/>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Phương tiện</label>
        <form:select class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                     path="vehicle" items="${vehicleList}"/>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Số hiệu phương tiện</label>
        <form:input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                    path="vehicleCode"/>
        <label for="exampleInputEmail1" class="form-label">Số ghế</label>
        <form:input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                    path="numberOfSeats"/>
    </div>
        <label>Ngày khởi hành</label>
        <form:select path="startDate" items="${dateList}"></form:select>
        <form:select path="monthStart" items="${monthList}"></form:select>
        <form:select path="yearStart" items="${yearList}"></form:select><br>
    </div>
    <div>
        <label>Ngày kết thúc</label>
        <form:select path="endDate" items="${dateList}"></form:select>
        <form:select path="monthEnd" items="${monthList}"></form:select>
        <form:select path="yearEnd" items="${yearList}"></form:select><br>
    </div>
    <div>
        <label>Trong vòng 14 ngày qua, anh/chị đã đến tỉnh/thành phố nào?</label>
        <form:textarea path="notification"/>
    </div>
    <button type="submit">Gửi tờ khai</button>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

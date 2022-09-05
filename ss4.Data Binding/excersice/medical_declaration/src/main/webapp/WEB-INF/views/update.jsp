<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/17/2022
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/submit" method="post" modelAttribute="paperDeclaration">
    <div>
        <form:hidden path="id" value="${paperDeclaration1.id}"/>
    </div>
    <div>
        <label>Họ tên</label>
        <form:input value="${paperDeclaration1.name}" path="name" type="text"/>
    </div>
    <div>
        <label>Năm sinh</label>
        <form:select path="yearOfBirth" items="${yearOfBirthList}"></form:select>
        <label>Giới Tính</label>
        <form:select path="gender" items="${genderList}"></form:select>
        <label>Quốc Tịch</label>
        <form:select path="nation" items="${nationList}"></form:select>
    </div>
    <div>
        <label>Số hộ chiếu hoặc CMND hoặc giấy thông hành hợp pháp khác</label>
        <form:input path="identify" type="text" value="${paperDeclaration1.identify}"/>
    </div>
    <div>
        <label>Thông tin đi lại</label>
        <form:radiobuttons path="vehicle" items="${vehicleList}"></form:radiobuttons>
    </div>
    <div>
        <label>Số hiệu phương tiện</label>
        <form:input path="vehicleCode" value="${paperDeclaration1.vehicleCode}"/>
        <label>Số ghế</label>
        <form:input path="numberOfSeats" value="${paperDeclaration1.numberOfSeats}"/>
    </div>
    <div>
        <label>Ngày khởi hành</label>
        <form:select path="startDate" items="${dateList}"></form:select>
        <form:select path="monthStart" items="${monthList}"></form:select>
        <form:select path="yearStart" items="${yearList}"></form:select>
    </div>
    <div>
        <label>Ngày kết thúc</label>
        <form:select path="endDate" items="${dateList}"></form:select>
        <form:select path="monthEnd" items="${monthList}"></form:select>
        <form:select path="yearEnd" items="${yearList}"></form:select><br>
    </div>
    <div>
        <label>Trong vòng 14 ngày qua, anh/chị đã đến tỉnh/thành phố nào?</label>
        <form:textarea path="notification" value="${paperDeclaration1.notification}"/>
    </div>
    <button type="submit">Gửi tờ khai</button>
</form:form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/17/2022
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Quay lại trang list</a>
<p>ID:${paperDeclaration.id}</p>
<p>Họ tên: ${paperDeclaration.name}</p>
<p>Năm sinh: ${paperDeclaration.yearOfBirth}</p>
<p>Giới Tính: ${paperDeclaration.gender}</p>
<p>Quốc tịch: ${paperDeclaration.nation}</p>
<p>Số hộ chiếu: ${paperDeclaration.identify}</p>
<p>Thông tin đi lại: ${paperDeclaration.vehicle}</p>
<p>Số hiệu phương tiện: ${paperDeclaration.vehicleCode}</p>
<p>Số ghế: ${paperDeclaration.numberOfSeats}</p>
<p>Ngày khởi hành: ${paperDeclaration.startDate}/${paperDeclaration.monthStart}/${paperDeclaration.yearStart}</p>
<p>Ngày kết thúc: ${paperDeclaration.endDate}/${paperDeclaration.monthEnd}/${paperDeclaration.yearEnd}</p>
<p>Thông báo: ${paperDeclaration.notification}</p>
</body>
</html>

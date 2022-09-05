<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/12/2022
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang chuyen doi tien te</h1>
<form action="/convertPage2" method="post">
    <p>Nhap so tien</p>
    <input type="text" name="soTien" value="0" default>
    <p>Nhap ti gia</p>
    <input type="text" name="tiGia" value="0" default>
    <p>
        <button type="submit">Convert</button>
</form>
</body>
</html>

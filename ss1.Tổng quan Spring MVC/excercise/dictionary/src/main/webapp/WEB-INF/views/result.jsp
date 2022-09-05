<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/12/2022
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dictionary</h2>
<form action="/dictionary" method="get">
    <input type="text" name="word">
    <button type="submit">Search</button>
</form>
<h2>Ket qua la: ${result} </h2>
</body>
</html>

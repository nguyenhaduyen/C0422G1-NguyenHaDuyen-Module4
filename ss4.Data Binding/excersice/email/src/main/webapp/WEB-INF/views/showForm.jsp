<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/17/2022
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Language: ${formEmail.language}</th>
        <th>Page Size: ${formEmail.pageSize}</th>
        <th>Spams Filter: ${formEmail.spamsFilter}</th>
        <th>Signature: ${formEmail.signature}</th>
    </tr>
</table>
</body>
</html>

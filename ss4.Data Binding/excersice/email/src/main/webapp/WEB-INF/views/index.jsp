<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/17/2022
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="/save" method="post" modelAttribute="form">
    <p>Language</p><form:select path="language" items="${languageList}"/>
    <p>Page Size</p><form:select path="pageSize" items="${pageSizeList}"/>
    <p>Spams Filter</p><form:checkbox path="spamsFilter"/>
    <p>Signature</p><form:textarea path="signature"/>
    <button type="submit">Save</button>
</form:form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/16/2022
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/result">
    <input type="text" name="operator1">
    <input type="text" name="operator2">
    <button type="submit" value="addition" name="operand">Addition</button>
    <button type="submit" value="subtraction" name="operand">Subtraction</button>
    <button type="submit" value="multiplication" name="operand">Multiplication</button>
    <button type="submit" value="division" name="operand">Division</button>
</form>
<p>Result: ${result}</p>
</body>
</html>

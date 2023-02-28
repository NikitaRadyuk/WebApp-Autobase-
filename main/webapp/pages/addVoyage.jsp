<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18.12.2022
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="add-voyage"/>
    <h3>type of cargo:</h3>
    <input type="text" name="typeOfCargo" value=""/>
    <h3>route:</h3>
    <input type="text" name="route" value=""/>
    <h3>time:</h3>
    <input type="text" name="time" value=""/>
    <input type="submit" value="ADD"/>
</form>
</body>
</html>

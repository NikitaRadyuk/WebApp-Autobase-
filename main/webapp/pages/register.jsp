<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12.12.2022
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="controller" method="post">
  <input type="hidden" name="command" value="register"/>
  <h3>login:</h3>
  <input type="text" name="login" value=""/>
  <h3>password:</h3>
  <input type="password" name="password" value=""/>
  <h3>confirm password:</h3>
  <input type="password" name="confirm_password" value=""/>
  <h3>name:</h3>
  <input type="text" name="name" value=""/>
  <h3>surname:</h3>
  <input type="text" name="surname" value=""/>
  <h3>email:</h3>
  <input type="text" name="email" value=""/>
  <input type="submit" value="REGISTER"/>
</form>
</body>
</html>

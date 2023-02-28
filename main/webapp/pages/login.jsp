<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11.12.2022
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="login"/>
    <h3>login:</h3>
    <input type="text" name="login" value=""/>
    <h3>password:</h3>
    <input type="password" name="password" value=""/>
    <input type="submit" value="LOGIN"/>
</form>
</body>
</html>

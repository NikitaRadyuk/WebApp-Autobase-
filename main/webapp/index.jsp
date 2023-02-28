<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
</head>
<body class="text-center">
<main class="form-signin w-100 m-auto">
    ${user == null ? null : user.login}
        <a href="${pageContext.request.contextPath}/controller?command=show-register-page">Регистрация</a>
        <a href="${pageContext.request.contextPath}/controller?command=show-login-page">Войти</a>
</main>
</body>
</html>
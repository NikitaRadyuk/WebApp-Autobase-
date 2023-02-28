<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11.12.2022
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are at HomePage</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
${user_data.name}
<c:if test="${user_data != null}">
    <jsp:useBean id="user_data" scope="session" type="by.radyuk.myautobase.model.entity.User"/>
    ${user_data.role}
    <c:if test="${user_data.role.id == 1}">
    <a href="${pageContext.request.contextPath}/controller?command=show-addVoyage-page" >addVoyage</a>
</c:if>
<c:if test="${user_data.role.id == 2}">
    <a href="${pageContext.request.contextPath}/controller?command=show-freeVoyages-page">freeVoyages</a>
</c:if>
</c:if>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18.12.2022
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voyages</title>
    <link href="WEB-INF/index.jsp" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<c:if test="${free_voyages != null}">
    <jsp:useBean id="free_voyages" scope="session" type="java.util.List"/>
<table>
    <tr><th>Type:</th><th>Route:</th><th>Time:</th><th></th></tr>
    <c:forEach var="voyage" items="${free_voyages}">
        <jsp:useBean id="voyage" type="by.radyuk.myautobase.model.entity.Voyage"/>
        <tr><td>${voyage.typeOfCargo}</td>
        <td>${voyage.route}</td>
        <td>${voyage.time}</td>
            <td><a href="${pageContext.request.contextPath}/controller?command=select-voyage&id=${voyage.idVoyage}">
                SELECT
            </a></td>
        </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>

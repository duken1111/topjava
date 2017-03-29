<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>User list</h2>
<table>
    <tbody>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Mail</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <jsp:useBean id="user" type="ru.javawebinar.topjava.model.User" scope="page" />
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>

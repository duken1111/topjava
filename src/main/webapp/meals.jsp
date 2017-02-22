<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meals list</h2>

 <table border="1">
     <tbody>

        <c:forEach var="meal" items="${mealsList}">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed" />
            <tr>
                <td>${meal}</td>
            </tr>
        </c:forEach>
     </tbody>
 </table>
</body>
</html>

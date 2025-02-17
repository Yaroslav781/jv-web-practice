<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get All Cars</title>
</head>
<body>
<h1>List of cars:</h1>
<table>
    <tr>
    <td>Id</td>
    <td>Model</td>
    <td>Manufacturer</td>
    <td>Drivers</td>
    <td>Delete</td>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td><c:out value="${car.id}" /></td>
            <td><c:out value="${car.model}" /></td>
            <td>
                <c:out value="${car.manufacturer.name}" />
                <c:out value ="${car.manufacturer.country}" />
            </td>
            <td>
                <c:forEach items="${car.drivers}" var="driver">
                    <c:out value="${driver.name}" />
                    <c:out value="${driver.licenseNumber}" />
                </c:forEach>
            </td>
            <td><a href="${pageContext.request.contextPath}/cars/delete?id=${car.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

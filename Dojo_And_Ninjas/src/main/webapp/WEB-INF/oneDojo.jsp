<%--
  Created by IntelliJ IDEA.
  User: nikhilvirparia
  Date: 10/11/21
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title Here</title>
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container"> <!-- Beginning of Container -->

    <h1> <c:out value="${dojo.name}"></c:out> Location Ninjas </h1>
    <a href="/dojos/new"> Go back </a>
    <br>
    <br>


    <table>
        <tbody>

        <c:forEach var="i" items="${dojo.ninjas}">
        <tr>
            <td> First name: </td>
            <td> <c:out value="${i.firstName}"></c:out></td>
        </tr>

        <tr>
            <td> Last Name: </td>
            <td> <c:out value="${i.lastName}"></c:out></td>
        </tr>

        <tr>
            <td> Age: </td>
            <td> <c:out value="${i.age}"></c:out></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</div> <!-- End of Container -->
</body>
</html>

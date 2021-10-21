<%--
    Team: Spooky
    Date: 10/21/21
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
    <a href="/logout">Logout</a>
    <a href="/costume/chooser">Dashboard</a>

    <h1> Ideas for a ${costumeName} </h1>
    <a href="/costume/chooser"> Costume Chooser </a>
    <c:forEach var="i" begin="1" end="6">
        <img src="/resources/images/${costumeName}/O${i}.jpeg" alt="Images">
    </c:forEach>

</div> <!-- End of Container -->
</body>
</html>

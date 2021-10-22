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

    <!-- CSS -->
    <link rel="stylesheet" href="/resources/CSS/result.css">

    <!-- Google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Qahiri&display=swap" rel="stylesheet">

</head>
<body>
<div class=".container1"> <!-- Beginning of Container -->

    <h1>
        <a href="/costume/chooser">
            <input class="logout" type="submit" value="Dashboard">
        </a>
        <a href="/logout">
            <input class="logout" type="submit" value="Logout">
        </a>
    </h1>

    <div class="midwrapper">
        <div class="middle">
            <h1>This Year you will be a....</h1>
        </div>
        <div class="middle">
            <h4> ${costumeName} </h4>
        </div>

        <div class="middle">
            <form action="/costume/picture" method="POST">
                <input class="button" type="submit" value="Show me ideas">
            </form>


            <form action="/costume/chooser" method="POST">
                 <input class="button" type="submit" value="Pick another Costume">
            </form>
        </div>
    </div>

</div> <!-- End of Container -->
</body>
</html>

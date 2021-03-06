<%--
  User: nikhilvirparia
  Date: 10/7/21
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

    <h1> Expense Details </h1>
    <a href="/"> Go back </a>
    <br>
    <br>
    <table>
        <tbody>

        <tr>
            <td> Expense name: </td>
            <td> <c:out value="${expense.expenseName}"></c:out></td>
        </tr>

        <tr>
            <td> Expense Description: </td>
            <td> <c:out value="${expense.description}"></c:out></td>
        </tr>

        <tr>
            <td> Vendor: </td>
            <td> <c:out value="${expense.vendor}"></c:out></td>
        </tr>

        <tr>
            <td> Amount Spent: </td>
            <td> <c:out value="${expense.amount}"></c:out></td>
        </tr>

        </tbody>
    </table>




</div> <!-- End of Container -->
</body>
</html>

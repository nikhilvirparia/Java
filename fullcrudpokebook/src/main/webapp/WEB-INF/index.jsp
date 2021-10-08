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
    <title>PokeBook</title>
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container"> <!-- Beginning of Container -->

    <h1>PokeBook</h1>
    <a href="/expenses"> Expense details </a>
    <a href="/expenses/edit"> Edit Expense </a>

    <table>
        <tbody>
        <tr>
            <th> &nbsp;&nbsp;Expense </th>
            <th> Vendor </th>
            <th> Amount </th>
        </tr>
        <c:forEach var="i" items="${expenses}">
            <tr>
                <td> <c:out value="${i.expenseName}"></c:out></td>
                <td> <c:out value="${i.vendor}"></c:out></td>
                <td> <c:out value="${i.amount}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <h1>Track an Expense:</h1>
    <form:form action="/pokes" method="post" modelAttribute="expense">
        <p>
            <form:label path="expenseName">Expense Name</form:label>
            <form:errors path="expenseName"/>
            <form:input path="expenseName"/>
        </p>
        <p>
            <form:label path="vendor">Vendor</form:label>
            <form:errors path="vendor"/>
            <form:textarea path="vendor"/>
        </p>
        <p>
            <form:label path="amount">Amount</form:label>
            <form:errors path="amount"/>
            <form:input type="number" path="amount"/>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:textarea path="description"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>

</div> <!-- End of Container -->
</body>
</html>
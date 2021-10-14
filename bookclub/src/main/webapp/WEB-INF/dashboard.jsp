<%--
  Created by IntelliJ IDEA.
  User: nikhilvirparia
  Date: 10/14/21
  Time: 12:09 AM
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

    <div style="margin:15px">
        <div style="display:flex; justify-content:space-between;">
            <h1>Welcome, <c:out value="${user.userName}"></c:out></h1>
            <a href="/logout">Logout</a>
        </div>
        <div style="display:flex; justify-content:space-between;">
            <p>Books from all the shelves:</p>
            <a href="/books/new">+ Add to my shelf</a>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope = "col">ID</th>
                <th scope = "col">Title</th>
                <th scope = "col">Author Name</th>
                <th scope = "col">Posted By</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><c:out value="${book.getId()}"></c:out></td>
                    <td><a href="/books/${book.getId()}"><c:out value="${book.getTitle()}"></c:out></a></td>
                    <td><c:out value="${book.getAuthor()}"></c:out></td>
                    <td><c:out value="${book.getUser().userName}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div> <!-- End of Container -->
</body>
</html>

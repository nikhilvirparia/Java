<%--
  Created by IntelliJ IDEA.
  User: nikhilvirparia
  Date: 10/13/21
  Time: 1:47 PM
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
    <h1> Welcome <c:out value="${user.userName}"></c:out></h1>

    <div style="margin:15px">
        <div style="margin:15px;display:flex; justify-content:space-between;">
            <h1><c:out value="${book.getTitle()}"></c:out></h1>
            <a href="/books">back to the shelves</a>
        </div>
        <div style="margin:15px">
            <p><c:out value="${book.getUser().getUserName()} read ${book.getTitle()} by ${book.getAuthor()}."></c:out></p>
            <p><c:out value = "Here are ${book.getUser().getUserName()}'s thoughts:"></c:out></p>
        </div>
        <div style="width:50%;margin:20px; padding:25px;;border-top:4px solid black; border-bottom: 4px solid black;">
            <p><c:out value="${book.getThoughts()}"></c:out></p>
        </div>
        <c:if test = "${book.user.equals(user)}">
            <a href="/edit/${book.getId()}">edit</a>
            <form action="/delete/${book.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete">
            </form>
        </c:if>
    </div>



    <a href="/logout">Logout</a>
</div> <!-- End of Container -->
</body>
</html>

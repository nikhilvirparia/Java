<%--
  Created by IntelliJ IDEA.
  User: nikhilvirparia
  Date: 10/13/21
  Time: 1:48 PM
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

    <div style="margin:15px;">
        <div style="margin:15px;display:flex; justify-content:space-between;">
            <h1>Add a book to your shelf!</h1>
            <a href="/home">back to the shelves</a>
        </div>

        <form:form action="/books" method="post" modelAttribute="book">
            <form:hidden path = "user" value = "${user.id}" />
            <form:errors path="user" class="text-danger" />
            <p>
                <form:label path="title">Title</form:label>
                <form:errors path="title"/>
                <form:input path="title"/>
            </p>
            <p>
                <form:label path="author">Author</form:label>
                <form:errors path="author"/>
                <form:input path="author"/>
            </p>
            <p>
                <form:label path="thoughts">Thoughts</form:label>
                <form:errors path="thoughts"/>
                <form:textarea path="thoughts"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
    </div>

</div> <!-- End of Container -->
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: nikhilvirparia
  Date: 10/13/21
  Time: 1:49 PM
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
        <div style="display:flex;">
            <h1>Edit Book</h1>
            <a style="margin-left:auto;"href = "/books">back to shelf</a>
        </div>
        <form:form action="/books/${book.id}" method="post" modelAttribute="book">
            <input type="hidden" name="_method" value="put">
            <form:hidden path = "user" value = "${user.id}" />
            <p style="color:red;"><form:errors path="title"/></p>
            <p>
                <form:label path="title">Title</form:label>
                <form:input path="title"/>
            </p>
            <p style="color:red;"><form:errors path="author"/></p>
            <p>
                <form:label path="Author">Author</form:label>
                <form:input path="Author"/>
            </p>
            <p style="color:red;"><form:errors path="thoughts"/></p>
            <p>
                <form:label path="thoughts">My Thoughts</form:label>
                <form:textarea path="thoughts"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
    </div>

</div> <!-- End of Container -->
</body>
</html>

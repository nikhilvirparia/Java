<%--
  Created by IntelliJ IDEA.
  User: nikhilvirparia
  Date: 10/3/21
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/main.css"/>
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <title>Fruity Loops</title>
</head>
<body>

<h1> Hello</h1>
<table>

    <tbody>
        <thead>
            <th>Name</th>
            <th>Price</th>
        </thead>

    <c:forEach var="fruits" items="${ItemController}">
    <tr>
        <td>
            <p><c:out value="${fruits.getName()}"></c:out></p>
        </td>
        <td>
            <p><c:out value="${fruits.getPrice()}"></c:out></p>
        </td>
    </tr>
    </c:forEach>

    </tbody>

</table>

</body>
</html>

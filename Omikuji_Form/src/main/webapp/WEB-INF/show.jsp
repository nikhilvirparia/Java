<%--
  Created by IntelliJ IDEA.
  User: nikhilvirparia
  Date: 10/4/21
  Time: 5:07 PM
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
    <title>Show</title>
</head>
<body>

        <h1> Here's Your Omikuji! </h1>
        <h3> In <c:out value="${number}"></c:out> years, you will
            live in <c:out value="${cname}"></c:out> with
            <c:out value="${name}"></c:out> as your roommate, <c:out value="${hobby}"></c:out>
            for a living. The next time you see a <c:out value="${living}"></c:out>, you will have
            good luck. Also, <c:out value="${description}"></c:out>.
        </h3>

        <a href="/omikuji">Go back</a>

</body>
</html>

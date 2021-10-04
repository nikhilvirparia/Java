<%--
  Created by IntelliJ IDEA.
  User: nikhilvirparia
  Date: 10/4/21
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Omikuji Form</title>
</head>
<body>

<h1> Hello </h1>

    <form action="/create" method="POST">
        <p> Pick any number from 5 to 25 </p>
        <input type="number" name="number">

        <p>Enter the name of any city</p>
        <input type="text" name="cname">

        <p>Enter the name of any real person</p>
        <input type="text" name="name">

        <p>Enter professional endeavor or hobby</p>
        <input type="text" name="hobby">

        <p>Enter any type of living thing</p>
        <input type="text" name="living">

        <p>Say something nice to someone:</p>
        <textarea name="description" rows="4" cols="50"> </textarea>

        <p> Send and show a friend </p>
        <input type="submit" value="Send">

    </form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 3/18/18
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form name="registrationForm" method="POST" action="/controller">
    <label for="username">User name:</label><br/>
    <input type="text" name="username" id="username" value=""/><br/>
    <label for="email">Email:</label><br/>
    <input type="text" name="email" id="email" value=""/><br/>
    <label for="password">Password:</label><br/>
    <input type="password" name="password" id="password" value=""/><br/>
    <input type="submit" value="register"/>
</form>
<p> ${message}</p>
</body>
</html>

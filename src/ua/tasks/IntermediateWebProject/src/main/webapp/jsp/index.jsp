<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 4/5/18
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Liability insurances service</title>
</head>
<body>
<h2 align="center" style="background-color:DodgerBlue;">Welcome to liability insurance service</h2>
<p align="center" style="border: 2px solid DodgerBlue;">This service is used for internal usages in insurance company</p>
<form name="registrationForm" method="POST" action="">
    <label for="username">User name:</label><br/>
    <input type="text" name="username" id="username" value=""/><br/>
    <label for="password">Password:</label><br/>
    <input type="password" name="password" id="password" value=""/><br/>
    <input type="submit" value="login"/>
</form>
<p align="center"><a href="${pageContext.request.contextPath}/controller?act=load">Load liability insurances</a></p>
</body>
</html>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
 <%--
      Created by IntelliJ IDEA.
      User: alex
      Date: 3/19/18
      Time: 12:30 AM
      To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome ${user.userName}</title>
</head>
<body>
<h2>SUCCESSFUL REGISTRATION!!</h2>
Name: ${user.userName}<br/>
EMAIL: ${user.email}<br/>

<form method="POST" name="registrationForm" class="form-signin" action="${contextPath}controller?act=delete">
    <h2 class="form-signin-heading">Edit account</h2>
    <div class="form-group">
        <p style="color:red;"> ${message}</p>
        <input type="text" class="form-control" name="username" value="${user.userName}"/>
    </div>

    <div class="form-group">
        <input type="text" class="form-control" name="email" value="${user.email}"/>
    </div>

    <div class="form-group">
        <input type="password" class="form-control" name="password" placeholder="Password"/>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Remove</button>
    <h4 class="text-center"><a href="${contextPath}/login.jsp">Login</a></h4>
</form>

</body>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CRUD</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%--<h2>Read result</h2>
Name: ${user.userName}<br/>
EMAIL: ${user.email}<br/>--%>

<form method="POST" name="form" class="form-signin">
    <h2 class="form-signin-heading">Registration Form</h2>
    <div class="form-group">
        <p style="color:red;"> ${error}</p>
        <p style="color:green;"> ${message}</p>
        <input type="hidden" name="id" value="${savedUser.id}"/>
        <p style="color:green">${user.userName}</p>
        <input type="text" class="form-control" name="username"
               placeholder="${(empty savedUser) ? 'UserName' : savedUser.userName}" value="${savedUser.userName}"/>
    </div>

    <div class="form-group">
        <p style="color:green">${user.email}</p>
        <input type="text" class="form-control" name="email"
               placeholder="${(empty savedUser) ? 'Email' : savedUser.email}" value="${savedUser.email}"/>
    </div>

    <div class="form-group">
        <input type="password" class="form-control" name="password" placeholder="Password"/>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="button" onclick="return OnCreate();">Create</button>
    <button class="btn btn-lg btn-primary btn-block" type="button" onclick="return OnRead();">ReadByName</button>
    <button class="btn btn-lg btn-primary btn-block" type="button" onclick="return OnUpdate();">Update</button>
    <button class="btn btn-lg btn-primary btn-block" type="button" onclick="return OnDelete();">Delete</button>
</form>

<script language="Javascript">
    /**
     * @return {boolean}
     */
    function OnCreate() {
        document.form.action = "create"
        document.form.submit();
        return true;
    }

    /**
     * @return {boolean}
     */
    function OnRead() {
        document.form.action = "read"
        document.form.submit();
        return true;
    }

    /**
     * @return {boolean}
     */
    function OnUpdate() {
        document.form.action = "update"
        document.form.submit();
        return true;
    }

    /**
     * @return {boolean}
     */
    function OnDelete() {
        document.form.action = "delete"
        document.form.submit();
        return true;
    }
</script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

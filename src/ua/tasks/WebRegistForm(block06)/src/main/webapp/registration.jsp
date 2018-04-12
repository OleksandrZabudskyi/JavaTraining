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

    <title>Create an account</title>

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

<div class="container">

    <form method="POST" name="registrationForm" class="form-signin" action="${contextPath}/registration">
        <h2 class="form-signin-heading">Create your account</h2>
        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username" autofocus="true"/>
        </div>

        <div class="form-group">
            <input type="text" class="form-control" name="email" placeholder="Email" autofocus="true"/>
        </div>

        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password"/>
        </div>

        <div class="form-group">
            <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm your password"/>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        <h4 class="text-center"><a href="${contextPath}/login">Login</a></h4>
        </form>
    <p> ${message}</p>
</div>

<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

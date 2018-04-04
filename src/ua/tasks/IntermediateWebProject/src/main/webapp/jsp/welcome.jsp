<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 3/18/18
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Liability insurances</title>
</head>
<body>
<div align="right">
    <form name="searchParamForm" method="POST" action="${pageContext.request.contextPath}/controller?act=find">
        <label for="price">Liability Price:</label>
        <input type="text" name="price" id="price" value=""/><br/>
        <label for="risk">Risk:</label>
        <input type="text" name="risk" id="risk" value=""/><br/>
        <input type="submit" value="Find"/>
    </form>
</div>

<div align="center">
    <form name="create" method="GET" action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="act" value="create"/>
        <input type="submit" value="Create Derivative"/>
    </form>
</div>

<c:choose>
    <c:when test="${cookie.Derivative.value != null}">
        <div align="center">
            <form name="getPrice" method="GET" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="act" value="getPrice"/>
                <input type="submit" value="Count"/>
            </form>
            <p> ${derivativePrice}</p>
        </div>

        <div align="center">
            <form name="sort" method="GET" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="act" value="sort"/>
                <input type="submit" value="Sort"/>
            </form>
        </div>
    </c:when>
</c:choose>



<p> ${message}</p>

<div align="center">
    <table border="1" cellpadding="5">
<c:choose>
    <c:when test="${cookie.Derivative.value}">
        <caption><h2>Liability Insurances</h2></caption>
    </c:when>
    <c:otherwise>
        <caption><h2>${cookie.Derivative.value}</h2></caption>
    </c:otherwise>
</c:choose>
        <tr>
            <th>Name</th>
            <th>Liability Price</th>
            <th>Risk</th>
        </tr>
        <c:forEach var="liability" items="${liabilities}">
            <tr>
                <td><c:out value="${liability}"/></td>
                <td><c:out value="${liability.liabilityPrice}" /></td>
                <td><c:out value="${liability.risk}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

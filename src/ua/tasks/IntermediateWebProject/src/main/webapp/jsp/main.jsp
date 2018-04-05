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

<a href="${pageContext.request.contextPath}/controller">Logout</a>

<c:if test="${tableName == 'Derivative'}">
    <div align="right">
            <form name="searchParamForm" method="POST" action="${pageContext.request.contextPath}/controller?act=find">
                <label for="price">Liability Price:</label>
                <input type="text" name="price" id="price" value=""/><br/>
                <label for="risk">Risk:</label>
                <input type="text" name="risk" id="risk" value=""/><br/>
                <input type="submit" value="Find"/>
            </form>
        </div>
    </div>
</c:if>

<div align="center">
    <div style="display:inline-block;">
        <form name="create" method="GET" action="${pageContext.request.contextPath}/controller">
            <input type="hidden" name="act" value="create"/>
            <input type="submit" value="Create Derivative"/>
        </form>
    </div>

    <c:if test="${tableName == 'Derivative'}">
        <div style="display:inline-block;">
            <form name="getPrice" method="GET" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="act" value="getPrice"/>
                <input type="submit" value="Count"/>
            </form>

        </div>

        <div style="display:inline-block;">
            <form name="sort" method="GET" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="act" value="sort"/>
                <input type="submit" value="Sort"/>
            </form>
        </div>
    </c:if>
    <p style="color:green;"><c:if
            test="${derivativePrice != null}">Total derivative price: ${derivativePrice} UAH</c:if></p>
</div>

<p align="center" style="color:green;">${message}</p>

<div align="center">
    <table border="1" cellpadding="5">
        <c:if test="${tableName != null}">
            <caption><h2>${tableName}</h2></caption>
        </c:if>
        <tr>
            <th>Name</th>
            <th>Params</th>
            <th>Liability Price UAH</th>
            <th>Risk 100 %</th>
        </tr>
        <c:forEach var="liability" items="${liabilities}">
            <tr>
                <c:set var="object" value="${liability}" />
                <td>
                    <c:out value="${object['class'].simpleName}"/>
                </td>
                <td>
                    <c:if test="${not empty object['class'].declaredFields}">
                        <ul>
                            <c:forEach var="field" items="${object['class'].declaredFields}">
                                <c:catch><li><span>${field.name}: </span>${object[field.name]}</li></c:catch>
                            </c:forEach>
                        </ul>
                    </c:if>
                </td>
                <td><c:out value="${object.liabilityPrice}"/></td>
                <td><c:out value="${object.risk}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/8/11
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>管理员列表</title>
    <c:set value="${pageContext.request.contextPath}" var="root"/>
</head>
<body>
<table>
    <c:forEach items="${requestScope.admins}" var="admin">
        <tr>
            <td>${admin.adminName}</td><td>${admin.adminPassword}</td><td>${admin.adminEmail}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

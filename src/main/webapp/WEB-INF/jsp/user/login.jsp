<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/9/5
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>登陆</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>

    <%--bootstrap--%>
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap-3.0/css/bootstrap.min.css">

    <%--jquery--%>
    <script src="${root}/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <%--bootstrap--%>
    <script src="${root}/resources/bootstrap-3.0/js/bootstrap.min.js" type="text/javascript"></script>

    <link type="text/css" rel="stylesheet" href="${root}/resources/user/css/login-custom.css">
    <script src="${root}/resources/user/js/login-custom.js" type="text/javascript"></script>
</head>
<body>

<!-- LOGIN FORM -->
<div class="text-center" style="padding:50px 0">
    <div class="logo">登陆</div>
    <!-- Main Form -->
    <div class="login-form-1">
        <form id="login-form" class="text-left" action="${root}/user/login" method="post">
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
                <div class="login-group">
                    <div class="form-group">
                        <label for="lg_username" class="sr-only">Username</label>
                        <input type="text" class="form-control" id="lg_username" name="userName" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label for="lg_password" class="sr-only">Password</label>
                        <input type="password" class="form-control" id="lg_password" name="userPassword" placeholder="password">
                    </div>
                    <div class="form-group login-group-checkbox">
                        <input type="checkbox" id="lg_remember" name="remember">
                        <label for="lg_remember">remember</label>
                    </div>
                </div>
                <button type="submit" class="login-button">开</button>
            </div>
            <div class="etc-login-form">
                <p>忘记密码？<a href="${root}/user/forgot/page">点我~</a></p>
                <p>新用户？<a href="${root}/user/register/page">用户注册</a></p>
            </div>
        </form>
    </div>
    <!-- end:Main Form -->
</div>

</body>
</html>

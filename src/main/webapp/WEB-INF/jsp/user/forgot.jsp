<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%
    Cookie[] cookies = request.getCookies();
    String user = null;
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if ("user".equals(cookies[i].getName().toString())) {
                user = cookies[i].getValue();
                user = URLDecoder.decode(user, "utf-8");
            }
            out.print(cookies[i].getName() + ":" + cookies[i].getValue() + "<br/>");
        }
    }
%>
<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/9/5
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>登陆&注册</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-theme.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/dataTables/media/css/dataTables.bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/user/css/login-custom.css">

    <script src="${root}/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="${root}/user/js/login-custom.js" type="text/javascript"></script>

    <!-- All the files that are required -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
</head>
<body>

<!-- FORGOT PASSWORD FORM -->
<div class="text-center" style="padding:50px 0">
    <div class="logo">forgot password</div>
    <!-- Main Form -->
    <div class="login-form-1">
        <form id="forgot-password-form" class="text-left">
            <div class="etc-login-form">
                <p>When you fill in your registered email address, you will be sent instructions on how to reset your password.</p>
            </div>
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
                <div class="login-group">
                    <div class="form-group">
                        <label for="fp_email" class="sr-only">Email address</label>
                        <input type="text" class="form-control" id="fp_email" name="fp_email" placeholder="email address">
                    </div>
                </div>
                <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
            </div>
            <div class="etc-login-form">
                <p>already have an account? <a href="#">login here</a></p>
                <p>new user? <a href="#">create new account</a></p>
            </div>
        </form>
    </div>
    <!-- end:Main Form -->
</div>
<script>
    $(document).ready(function () {
        $("#btn_add_user").click(function () {
            $.ajax({
                url: "/user/add",
                cache: false, // 禁用缓存
                contentType : false, // 告诉jQuery不要去设置Content-Type请求头
                processData : false, // 告诉jQuery不要去处理发送的数据
                async: false,
                type: "post",
                dataType: "json",
                data: new FormData($("#addUploadForm")[0]),
                success: function (data) {
                    if (data == 1) {
                        if (typeof userTable === "function") {
                            userTable().Init.ajax.reload()
                        }
                        $(".bootbox-close-button").click();
                    } else {
                        alert("添加失败");
                        $(".bootbox-close-button").click();
                    }
                },
                error: function () {
                    alert("通信失败");
                    $(".bootbox-close-button").click();
                }
            });
        });
    });
</script>

</body>
</html>

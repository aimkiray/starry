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
    <title>忘记密码</title>
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

<div class="text-center" style="padding:50px 0">
    <div class="logo">忘记密码</div>

    <div class="login-form-1">
        <form id="forgot-password-form" class="text-left">
            <div class="etc-login-form">
                <p>输入您注册时的邮箱，稍后会有邮件提示，大概。</p>
            </div>
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
                <div class="login-group">
                    <div class="form-group">
                        <label for="fp_email" class="sr-only">邮箱地址</label>
                        <input type="text" class="form-control" id="fp_email" name="fp_email" placeholder="email address">
                    </div>
                </div>
                <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
            </div>
            <div class="etc-login-form">
                <p>已有账户？<a href="${root}/user/login/page">登陆</a></p>
                <p>新用户？<a href="${root}/user/register/page">用户注册</a></p>
            </div>
        </form>
    </div>

</div>
<%--<script>
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
</script>--%>

</body>
</html>

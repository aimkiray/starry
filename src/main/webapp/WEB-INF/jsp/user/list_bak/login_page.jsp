<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/7/4
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>blog</title>
    <c:set var="root" value="${pageContext.request.contextPath}" />
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-theme.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/dataTables/media/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${root}/user/css/login.css">

    <script src="${root}/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="${root}/user/js/login.js" type="text/javascript"></script>
</head>
<body>
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

<form class="login-content" name="login" action="/user/login" method="post">
    <table class="login-table">
        <tr>
            <td colspan="4" class="title">用户登录</td>
        </tr>
        <tr>
            <td class="login-text">用户名：</td>
            <td colspan="2"><input type="text" value="" name="userName" id="userName" onblur="checkRegular('username',this)"></td>
            <td class="login-prompt"><span style="color: #00FFFF">&nbsp;中文</span></td>
        </tr>
        <tr>
            <td class="login-text">密码：</td>
            <td colspan="2"><input type="password" name="userPassword" id="userPassword" onblur="checkRegular('userpassword',this)"></td>
            <td class="login-prompt"><span style="color: #00FFFF">&nbsp;数字，字母</span></td>
        </tr>
        <tr>
            <td colspan="4" class="bottom-buttons">
                <a href="javascript:document.login.submit();">登陆</a>
                <a href="###" id="btn_add">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    if(top != self) {
        top.location.href = "/author/login/page";
    }
$(document).ready(function () {
    $("#btn_add").click(function () {
        $.ajax({
            url: "/user/add/page",
            type: "post",
            dataType: "text",
            success: function (data) {
                bootbox.dialog({
                    message: data,
                    title: "用户注册"
                })
            },
            error: function () {
                alert("通信失败");
            }
        });
    });
})
</script>
</html>

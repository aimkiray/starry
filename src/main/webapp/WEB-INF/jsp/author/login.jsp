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
<script>
    if(top != self) {
        top.location.href = "/WEB-INF/jsp/user/login.jsp";
    }
</script>
<html>
<head>
    <title>blog</title>
    <c:set var="root" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" type="text/css" href="${root}/user/css/login.css">
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
<form class="login-content" name="login" action="/user/verify.do" method="post">
    <table class="login-table">
        <tr>
            <td colspan="4" class="title">作者登录</td>
        </tr>
        <tr>
            <td class="login-text">用户名：</td>
            <td colspan="2"><input type="text" value="${user}" name="authorName" id="authorName" onblur="checkRegular('authorname',this)"></td>
            <td class="login-prompt"><span style="color: #00FFFF">&nbsp;中文</span></td>
        </tr>
        <tr>
            <td class="login-text">密码：</td>
            <td colspan="2"><input type="password" name="authorPassword" id="authorPassword" onblur="checkRegular('authorpassword',this)"></td>
            <td class="login-prompt"><span style="color: #00FFFF">&nbsp;数字，字母</span></td>
        </tr>
        <tr>
            <td colspan="4" class="bottom-buttons">
                <a href="javascript:document.login.submit();">登陆</a>
                <a href="/user/register.do">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

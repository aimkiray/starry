<%--
  Created by IntelliJ IDEA.
  User: nekuata
  Date: 2017/7/20
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>作者管理</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-theme.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-table.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-editable.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap-3.3.7-dist/css/user-custom.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">

    <script src="${root}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-table.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-table-zh-CN.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/extension/editable/bootstrap-editable.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/extension/editable/bootstrap-table-editable.js" type="text/javascript"></script>

    <script src="${root}/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/bootstrap-3.3.7-dist/js/user-custom.js" type="text/javascript"></script>
</head>

<body>

<div class="panel-body">

    <form class="form-inline" id="formSearch">

        <%--昵称模糊搜索--%>
        <div class="form-group" style="margin-top: 5px">
            <label for="nickNameSearch">昵称：</label>
            <input type="text" class="form-control" id="nickNameSearch" placeholder="请输入昵称">
        </div>

        <%--用户名模糊搜索--%>
        <div class="form-group" style="margin-top: 5px;margin-left: 10px">
            <label for="authorNameSearch">用户名：</label>
            <input type="text" class="form-control" id="authorNameSearch" placeholder="请输入用户名">
        </div>

        <%--确认按钮--%>
        <input type="button" id="btn_query" class="btn btn-primary" style="margin-top: 5px;margin-left: 10px" value="查询">
    </form>

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_edit" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>
    <table id="tb_author"></table>
</div>
</body>
</html>

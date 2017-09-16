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
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/dataTables/media/css/dataTables.bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/css/panel/author-custom.css">

    <script src="${root}/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="${root}/js/panel/author-custom.js" type="text/javascript"></script>
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
            <label for="userNameSearch">用户名：</label>
            <input type="text" class="form-control" id="userNameSearch" placeholder="请输入用户名">
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

    <table id="user_list" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th><input type="checkbox"></th>
            <th>头像</th>
            <th>编号</th>
            <th>用户名</th>
            <th>昵称</th>
            <th>简介</th>
            <th>注册时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody></tbody>
        <!-- tbody是必须的 -->
    </table>
</div>
</body>
</html>

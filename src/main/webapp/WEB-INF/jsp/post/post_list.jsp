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
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap-theme.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/dataTables/media/css/dataTables.bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/post/css/post-custom.css">

    <script src="${root}/resources/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/resources/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="${root}/resources/post/js/post-custom.js" type="text/javascript"></script>
</head>

<body>

<div class="panel-body">

    <%--<div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_edit" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>--%>

    <table id="post_list" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th><input type="checkbox"></th>
            <th>状态</th>
            <th>标题</th>
            <th>作者</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody></tbody>
        <!-- tbody是必须的 -->
    </table>
</div>
</body>
</html>

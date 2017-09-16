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
    <title>用户管理</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap-theme.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/dataTables/media/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="${root}/resources/css/ztree/demo.css" type="text/css">
    <link rel="stylesheet" href="${root}/resources/css/ztree/zTreeStyle/zTreeStyle.css" type="text/css">

    <script src="${root}/resources/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/resources/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript" src="${root}/resources/js/ztree/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${root}/resources/js/ztree/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${root}/resources/js/ztree/jquery.ztree.exedit.js"></script>
    <script type="text/javascript" src="${root}/resources/js/role/role-custom.js"></script>
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
            <label for="roleNameSearch">用户名：</label>
            <input type="text" class="form-control" id="roleNameSearch" placeholder="请输入用户名">
        </div>

        <%--确认按钮--%>
        <input type="button" id="btn_query" class="btn btn-primary" style="margin-top: 5px;margin-left: 10px" value="查询">
    </form>
    <br>

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

    <table id="role_list" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th><input type="checkbox"></th>
            <th>角色Id</th>
            <th>角色名称</th>
            <th>角色信息</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody></tbody>
        <!-- tbody是必须的 -->
    </table>
</div>
</body>
</html>

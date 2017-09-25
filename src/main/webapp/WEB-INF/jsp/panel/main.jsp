<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/8/17
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>控制面板</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>

    <%--bootstrap--%>
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap-3.0/css/bootstrap.min.css">
    <%--awesome--%>
    <link href="${root}/resources/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <%--datetimepicker--%>
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap-3.0/extension/datetimepicker/css/bootstrap-datetimepicker.min.css">
    <%--datatables--%>
    <link type="text/css" rel="stylesheet" href="${root}/resources/dataTables/css/dataTables.bootstrap.min.css">

    <%--jquery--%>
    <script src="${root}/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <%--bootstrap--%>
    <script src="${root}/resources/bootstrap-3.0/js/bootstrap.min.js" type="text/javascript"></script>
    <%--bootbox--%>
    <script src="${root}/resources/bootstrap-3.0/extension/bootbox/bootbox.min.js" type="text/javascript"></script>
    <%--datetimepicker--%>
    <script src="${root}/resources/bootstrap-3.0/extension/datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap-3.0/extension/datetimepicker/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <%--dataTables--%>
    <script src="${root}/resources/dataTables/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <%--ztree--%>
    <script type="text/javascript" src="${root}/resources/ztree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${root}/resources/ztree/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${root}/resources/ztree/js/jquery.ztree.exedit.js"></script>

    <link type="text/css" rel="stylesheet" href="${root}/resources/panel/css/panel-custom.css">
    <script src="${root}/resources/panel/js/panel-custom.js" type="text/javascript"></script>
</head>
<body>
<div class="row clearfix">
    <div class="col-md-12 column">
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">SInitial控制面板</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理<strong class="caret"></strong></a>
                        <ul id="treeDemo" class="dropdown-menu"></ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">更多功能<strong class="caret"></strong></a>
                        <ul class="dropdown-menu">
                            <li class="disabled">
                                <a href="#">一键删库</a>
                            </li>
                            <li class="disabled">
                                <a href="#">一键格盘</a>
                            </li>
                            <li class="disabled">
                                <a href="#">一键自毁</a>
                            </li>
                            <li class="divider">
                            </li>
                            <li class="disabled">
                                <a href="#">一键以上全部</a>
                            </li>
                            <li class="divider">
                            </li>
                            <li>
                                <a href="#">拖出去续了</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">${sessionScope.user.nickName}</a>
                    </li>
                    <li>
                        <a href="#">安全退出</a>
                    </li>
                    <li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<%--用来占位--%>
<nav class="navbar"></nav>
<%--主体部分--%>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="iframe-container">
                <iframe src="${pageContext.request.contextPath}/role/list/page" name="panel_container" width="800" frameborder="no" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
            </div>
        </div>
    </div>
</div>
<%--<div class="row clearfix">
    <div class="col-sm-12 column">
        <div class="col-sm-2">
            <ul id="treeDemo" class="ztree"></ul>
        </div>
        <div class="col-sm-10" id="mainScope">
            <div class="iframe-container">
                <iframe src="${pageContext.request.contextPath}/role/list/page" name="panel_container" width="800" frameborder="no" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
            </div>
        </div>
    </div>
</div>--%>
<input id="userRole" type="hidden" value="${sessionScope.user.userRole}">
<script type="text/javascript">
    var setting = {
        view: {
            showLine: false,
            showIcon: false,
            selectedMulti: false,
            dblClickExpand: false,
            addDiyDom: addDiyDom
        },
        callback: {
            beforeClick: beforeClick
        },
        data: {
            key: {
                name: "permissionName"
            },
            simpleData: {
                enable: true,
                idKey: "permissionId",
                pIdKey: "parentId",
                rootPId: 0
            }
        }
    };

    function addDiyDom(treeId, treeNode) {
        var spaceWidth = 5;
        var switchObj = $("#" + treeNode.tId + "_switch"),
            icoObj = $("#" + treeNode.tId + "_ico");
        switchObj.remove();
        icoObj.before(switchObj);

        if (treeNode.level > 1) {
            var spaceStr = "<span style='display: inline-block;width:" + (spaceWidth * treeNode.level)+ "px'></span>";
            switchObj.before(spaceStr);
        }
    }

    function beforeClick(treeId, treeNode) {
        if (treeNode.level == 0 ) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.expandNode(treeNode);
            window.open(treeNode.zz+"\\page","panel_container");
            return false;
        }
        return true;
    }

    $(document).ready(function () {
        $.ajax({
            type: "post",
            url: "/permission/menu/list",
            dataType: "json",
            data: {
                "userRole": $("#userRole").val()
            },
            cache: false,
            success: function (data) {
                $.fn.zTree.init($("#treeDemo"), setting, data);
            },
            error: function () {
                alert("通信失败！");
            }
        });
    });
</script>
</body>
</html>

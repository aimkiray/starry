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
<%@ page import="java.net.URLDecoder" %>
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
<html>
<head>
    <title>Title</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap-theme.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/dataTables/media/css/dataTables.bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/resources/css/panel/panel-custom.css">

    <%--<link rel="stylesheet" href="${root}/css/ztree/demo.css" type="text/css">--%>
    <link rel="stylesheet" href="${root}/resources/css/ztree/zTreeStyle/zTreeStyle.css" type="text/css">

    <script src="${root}/resources/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/resources/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="${root}/resources/js/panel/panel-custom.js" type="text/javascript"></script>

    <%--<script type="text/javascript" src="${root}/js/ztree/jquery-1.4.4.min.js"></script>--%>
    <script type="text/javascript" src="${root}/resources/js/ztree/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${root}/resources/js/ztree/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${root}/resources/js/ztree/jquery.ztree.exedit.js"></script>
</head>
<%--<style type="text/css">
    .ztree li span.button.add {
        margin-left: 2px;
        margin-right: -1px;
        background-position: -144px 0;
        vertical-align: top;
        *vertical-align: middle
    }
</style>--%>
<style type="text/css">
    .ztree * {font-size: 10pt}
    .ztree li ul{ margin:0; padding:0}
    .ztree li {line-height:30px;}
    .ztree li a {width:200px;height:30px;padding-top: 0px;}
    .ztree li a:hover {text-decoration:none; background-color: #E7E7E7;}
    .ztree li a span.button.switch {visibility:hidden}
    .ztree.showIcon li a span.button.switch {visibility:visible}
    .ztree li a.curSelectedNode {background-color:#D4D4D4;border:0;height:30px;}
    .ztree li span {line-height:30px;}
    .ztree li span.button {margin-top: -7px;}
    .ztree li span.button.switch {width: 16px;height: 16px;}

    .ztree li a.level0 span {font-size: 150%;font-weight: bold;}
    .ztree li span.button {background-image:url("${root}/resources/img/left_menuForOutLook.png"); *background-image:url("${root}/resources/img/left_menuForOutLook.gif")}
    .ztree li span.button.switch.level0 {width: 20px; height:20px}
    .ztree li span.button.switch.level1 {width: 20px; height:20px}
    .ztree li span.button.noline_open {background-position: 0 0;}
    .ztree li span.button.noline_close {background-position: -18px 0;}
    .ztree li span.button.noline_open.level0 {background-position: 0 -18px;}
    .ztree li span.button.noline_close.level0 {background-position: -18px -18px;}
</style>
<body>
<div class="row clearfix">
    <div class="col-md-12 column">
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">SINITIAL系统控制中心</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="#">文章</a>
                    </li>
                    <li>
                        <a href="#">个人信息</a>
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
<div class="row clearfix">
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
</div>
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
                /*var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                treeObj.expandAll(true);*/
            },
            error: function () {
                alert("通信失败！");
            }
        });
    });
</script>
</body>
</html>

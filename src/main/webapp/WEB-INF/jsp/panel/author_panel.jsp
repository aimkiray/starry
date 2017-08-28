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
    <title>Title</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${root}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${root}/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${root}/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="${root}/dataTables/media/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="${root}/panel/css/panel-custom.css">

    <script src="${root}/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap-3.3.7-dist/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="${root}/panel/js/panel-custom.js" type="text/javascript"></script>
</head>
<body>
<div class="container">

    <div class="row">

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
                    <%--<form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input class="form-control" type="text" />
                        </div> <button type="submit" class="btn btn-default">Submit</button>
                    </form>--%>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">${sessionScope.userName}</a>
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
        <div class="row clearfix">
        <div class="col-md-2">
            <ul class="nav nav-stacked nav-pills">
                <li class="active">
                    <a href="/panel/write_post.do" target="author_main">写文章</a>
                </li>
                <li>
                    <%--datatables表格插件--%>
                    <a href="#">文章管理</a>
                </li>
                <li class="disabled">
                    <a href="#">文件管理</a>
                </li>
            </ul>
        </div>

        <div class="col-md-10" id="mainScope">
            <div class="iframe-container">
                <iframe src="${pageContext.request.contextPath}/panel/write_post.do" name="author_main" width="650" height="400" frameborder="no" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
            </div>
        </div>

    </div>
    </div>
</div>
</body>
</html>

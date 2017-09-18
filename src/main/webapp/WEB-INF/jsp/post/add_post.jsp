<%--
  Created by IntelliJ IDEA.
  User: nekuata
  Date: 2017/9/18
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>写文章</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="${root}/resources/bootstrap/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="${root}/resources/dataTables/media/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="${root}/resources/css/font-awesome.min.css">

    <script src="${root}/resources/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/resources/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
</head>
<body>

<div class="container-fluid">

    <ul class="breadcrumb">
        <li>
            <a href="#">主页</a>
        </li>
        <li>
            <a href="#">Library</a>
        </li>
        <li class="active">
            Data
        </li>
    </ul>

    <div class="row form-inline">
        <div class="col-md-6 form-group">
            <label for="inputTag">输入标签</label>
            <input class="form-control" id="inputTag" name="tagName" type="text"/>
        </div>
        <div class="col-md-6 form-group">
            <label for="selectTag">已有标签</label>
            <select class="form-control" id="selectTag" name="tagId">
                <option value="0">请选择</option>
                <c:forEach items="${requestScope.tags}" var="tag">
                    <option value="${tag.tagId}">${tag.tagName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <br/>
    <form>

        <div class="form-group" id="formTag">

        </div>

        <div class="form-group">
            <label>标题</label>
            <input class="form-control" data-toggle="tooltip" placeholder="请输入标题">
        </div>
        <div class="form-group">
            <label>内容</label>
            <textarea class="form-control" data-toggle="tooltip" placeholder="Markdown格式内容"></textarea>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">发布</button>
            <button type="submit" class="btn btn-primary">保存</button>
        </div>
    </form>

</div>

</body>
</html>

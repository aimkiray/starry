<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/8/25
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写文章</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-theme.css">
    <link type="text/css" rel="stylesheet" href="${root}/bootstrap/css/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/dataTables/media/css/dataTables.bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${root}/css/panel/write_post.css">

    <script src="${root}/dataTables/media/js/jquery.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${root}/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="${root}/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/dataTables/media/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="${root}/js/panel/write_post.js" type="text/javascript"></script>
</head>
<body>

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

    <div class="form-group">
        <c:forEach items="${requestScope.postTags}" var="postTag">
            <span id="tagSpan${postTag.tagId}">
                <input class="form-control tagArea" type="text" value="${postTag.tagName}" readonly>
                <input type="hidden" name="tagId" value="${postTag.tagId}">
            </span>
        </c:forEach>
    </div>

    <div class="form-group">
        <label>标题</label>
        <input class="form-control" data-toggle="tooltip" title="请输入标题" value="${requestScope.postTitle}">
    </div>
    <div class="form-group">
        <label>内容</label>
        <textarea class="form-control" data-toggle="tooltip" title="Markdown格式内容">${requestScope.postContent}</textarea>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">保存</button>
        <button type="submit" class="btn btn-primary">发布</button>
    </div>
</form>


</body>
</html>

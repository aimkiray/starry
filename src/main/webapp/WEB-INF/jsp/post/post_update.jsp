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

    <script src="${root}/resources/post/js/post_update.js" type="text/javascript"></script>
</head>
<body>

<div class="container-fluid">

    <ul class="breadcrumb">
        <li>
            <a href="${root}/post/list/page" target="_self">文章管理</a>
        </li>
        <li class="active">
            魔改
        </li>
    </ul>

    <div class="row form-inline">
        <div class="col-md-6 form-group">
            <label for="inputTag">输入标签</label>
            <input class="form-control" id="inputTag" name="tagName" type="text"/>
            <input class="btn" id="addTag" type="button" value="确定">
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

    <form id="postUploadForm">

        <div class="form-group">
            <label for="tagArea">已选标签</label>
            <div class="row">
            <span class="col-md-11">
                <input class="form-control" id="tagArea" type="text" value="<c:forEach items="${requestScope.post.tags}" var="tag">${tag.tagName} </c:forEach>" readonly>
            </span>
            <span class="col-md-1">
                <input class="btn" id="cleanTag" type="button" value="清空">
            </span>
            </div>
        </div>

        <div class="form-group" id="formTag">
            <c:forEach items="${requestScope.post.tags}" var="tag">
                <input type="hidden" name="tagId" value="${tag.tagId}">
            </c:forEach>
        </div>

        <input type="hidden" id="postId" name="postId" value="${requestScope.post.postId}">
        <input type="hidden" id="postStatus" name="postStatus" value="${requestScope.post.postStatus}">
        <input type="hidden" id="postDate" name="postDate" value="${requestScope.post.postDate}">
        <input type="hidden" id="postAuthor" name="postAuthor" value="${requestScope.post.postAuthor}">
        <input type="hidden" id="postMimeType" name="postMimeType" value="${requestScope.post.postMimeType}">

        <div class="form-group">
            <label>标题</label>
            <input class="form-control" name="postTitle" value="${requestScope.post.postTitle}" placeholder="请输入标题">
        </div>

        <div class="form-group">
            <label>简介</label>
            <textarea class="form-control" name="postType" placeholder="首页显示的内容">${requestScope.post.postType}</textarea>
        </div>

        <div class="form-group">
            <label>内容</label>
            <textarea class="form-control" name="postContent" placeholder="Markdown格式 PS.右下角可拖动~">${requestScope.post.postContent}</textarea>
        </div>
        <div class="form-group">
            <input class="btn btn-primary" id="btn-publish" type="button" value="发布">
            <input class="btn btn-primary" id="btn-save" type="button" value="保存">
        </div>
    </form>

</div>

</body>
</html>

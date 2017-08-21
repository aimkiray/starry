<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/8/17
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>--%>
<%--<div class="container">--%>

<%--<div class="row clearfix">
    <div class="col-md-10 column">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

<%--<form role="form" class="form-inline">--%>
<div class="form-inline">
    <div class="form-group">
        <label for="inputTag">输入标签</label>
        <input class="form-control" id="inputTag" name="tagName" type="text"/>
    </div>
    <div class="form-group">
        <label for="selectTag">已有标签</label>
        <select class="form-select-button" id="selectTag" name="tagId">
            <option value="0">请选择</option>
            <c:forEach items="tags" var="tag">
                <option value="${tag.tagId}">${tag.tagName}</option>
            </c:forEach>
        </select>
    </div>
    <%--<button type="submit" class="btn btn-default">Submit</button>
    <input type="button" class="btn btn-default" value="确认">--%>
    <%--</form>--%>
</div>
<form class="form-horizontal" role="form">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
            <input class="form-control" id="inputEmail3" type="email"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input class="form-control" id="inputPassword3" type="password"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label><input type="checkbox"/>Remember me</label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Sign in</button>
        </div>
    </div>
</form>
<button type="button" class="btn btn-default">按钮</button>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--</body>
</html>--%>

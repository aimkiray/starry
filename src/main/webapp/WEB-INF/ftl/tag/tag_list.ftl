<#assign root=request.contextPath />

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>标签管理</title>
<#--bootstrap 4.0-->
    <link href="${root}/resources/bootstrap-4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<#--awesome-->
    <link href="${root}/resources/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<#--markdown css-->
    <link href="${root}/resources/post/css/wysiwyg.css" rel="stylesheet" type="text/css">

<#--jquery-->
    <script src="${root}/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
<#--markdown2html，使用showdown-->
    <script src="${root}/resources/showdown/showdown.js" type="text/javascript"></script>

    <script src="${root}/resources/tag/js/tag-custom.js" type="text/javascript"></script>
</head>

<body>

<div class="row">
    <div class="col-lg-6">
        <div class="input-group">
            <input type="text" class="form-control" id="inputTag" placeholder="标签名称" aria-label="标签名称">
            <span class="input-group-btn">
        <button class="btn btn-secondary" id="addTag" type="button">确认添加</button>
      </span>
        </div>
    </div>

    <div class="col-lg-6">
        <select class="custom-select" id="selectTag" name="tagId">
            <option value="0">选择标签</option>
        <#list tags as tag>
            <option value="${tag.tagId}">${tag.tagName}</option>
        </#list>
        </select>
    </div>
</div>

<br>

<div class="form-group">
    <label for="tagArea">修改标签</label>
    <div class="row">
            <span class="col-md-10">
                <input class="form-control" id="tagArea" type="text">
            </span>
        <span class="col-md-1">
                <input class="btn" id="updateTag" type="button" value="更新">
            </span>
        <span class="col-md-1">
                <input class="btn" id="delTag" type="button" value="删除">
            </span>
    </div>
</div>

<div class="form-group" id="formTag">
</div>

<br/>

</body>
</html>
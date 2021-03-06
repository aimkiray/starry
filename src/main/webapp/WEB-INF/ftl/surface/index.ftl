<#assign root=request.contextPath />

<!DOCTYPE html>
<html>
<script>
    if (top != self) {
        top.location.href = "/";
    }
</script>
<head>
    <meta charset="utf-8">
    <#--响应式标记-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="mobile-web-app-capable" content="yes">
    <title>☆Kira~</title>
<#--bootstrap 4.0-->
    <link href="${root}/resources/bootstrap-4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<#--awesome-->
    <link href="${root}/resources/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<#--markdown css-->
    <link href="${root}/resources/post/css/github-markdown.css" rel="stylesheet" type="text/css">
<#--highlight-->
    <link href="https://cdn.bootcss.com/highlight.js/9.12.0/styles/default.min.css" rel="stylesheet">

    <link href="${root}/resources/post/css/custom.css" rel="stylesheet" type="text/css">

    <#--jquery-->
    <script src="${root}/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <#--markdown2html-->
    <script src="https://cdn.bootcss.com/markdown-it/8.4.0/markdown-it.min.js"></script>
<#--highlight-->
    <script src="https://cdn.bootcss.com/highlight.js/9.12.0/highlight.min.js"></script>

</head>

<body>
<div class="content-wrapper">
    <div class="container-fluid">
        <div class="custom-row row">
            <div class="col-lg-1 hidden-small"></div>

        <#--功能面板-->
            <div class="col-lg-3 hidden-small">
                <#include "side.ftl" >
            </div>

        <#--首页文章区域-->
            <div class="content-column col-12 col-lg-7">
                <div class="list-group">

                <#list posts as post>
                    <input name="postId" type="hidden" value="${post.postId}">
                    <div class="post-wrapper">
                        <div class="post-content">
                            <a class="title-link"
                               href="${root}/article/${post.postId}" target="_self">${post.postTitle}</a>
                            <div class="text-block">
                                ${(post.postDate?string("yyyy-MM-dd"))!"none"}
                                &nbsp;|&nbsp;
                                <a class="text-link"
                                   href="###">${post.user.nickName}</a>
                                &nbsp;|&nbsp;
                                <#list (post.tags) as tag>
                                <a class="text-link"
                                   href="###">${(tag.tagName)!"none"}&nbsp;</a>
                                </#list>
                            </div>
                        </div>
                        <div class="post-text-content markdown-body">
                            <#--markdown格式原始文章-->
                            <div id="rawPost${post.postId}" style="display: none">${post.postType}</div>
                            <#--文章显示区域-->
                            <div class="paragraph" id="htmlPost${post.postId}"></div>
                        </div>
                    </div>
                </#list>

                </div>

            <#--全部文章-->
                <div class="button-wrapper"><a class="button" href="${root}/page/1">剩下的&nbsp;→</a></div>

            <#--显示区域宽度过小时显示的内容-->
                <div class="sidebar-on-mobile">
                    <#include "side.ftl" >
                </div>

            </div>
            <div class="col-lg-1 hidden-small"></div>
        </div>
    </div>
</body>

<script src="${root}/resources/post/js/custom.js" type="text/javascript"></script>
</html>
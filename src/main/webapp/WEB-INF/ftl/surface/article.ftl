<#assign root=request.contextPath />

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Hi, there..? :3</title>
    <#--bootstrap 4.0-->
    <link href="${root}/resources/bootstrap-4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <#--awesome-->
    <link href="${root}/resources/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <#--markdown css-->
    <link href="${root}/resources/post/css/github-markdown.css" rel="stylesheet" type="text/css">

    <#--jquery-->
    <script src="${root}/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <#--markdown2html，使用showdown-->
    <script src="${root}/resources/showdown/showdown.js" type="text/javascript"></script>

    <link href="${root}/resources/post/css/custom.css" rel="stylesheet" type="text/css">
    <script src="${root}/resources/post/js/custom.js" type="text/javascript"></script>
</head>

<body>
<div class="content-wrapper">
    <div class="container-fluid">
        <div class="custom-row row">

        <#--功能面板-->
            <div class="col col-3 hidden-small">
            <#include "side.ftl" >
            </div>

        <#--首页文章区域-->
            <div class="content-column col">
                <div class="list-group">

                    <div class="post-wrapper">
                        <input name="postId" type="hidden" value="${post.postId}">
                        <div class="post-content">
                            <a class="title-link"
                               href="###">${post.postTitle}</a>
                            <div class="text-block">
                                ${(post.postDate?string("yyyy-MM-dd"))!"none"}
                                &nbsp;|&nbsp;
                                <a class="text-link"
                                   href="###">${post.user.userName}</a>
                                &nbsp;|&nbsp;
                                <#list (post.tags) as tag>
                                    <a class="text-link"
                                       href="###">${(tag.tagName)!"none"}&nbsp;</a>
                                </#list>
                            </div>

                        </div>

                        <div class="post-text-content markdown-body">
                        <#--markdown格式原始文章-->
                            <div id="rawPost${post.postId}" style="display: none">${post.postContent}</div>
                        <#--文章显示区域-->
                            <div class="paragraph" id="htmlPost${post.postId}"></div>
                        </div>

                    </div>

                </div>

            <#--全部文章-->
                <div class="button-wrapper"><a class="button" href="${root}/page/1">其他的&nbsp;→</a></div>

            <#--宽度过小显示-->
                <div class="sidebar-on-mobile">
                <#include "side.ftl" >
                </div>
            </div>
        </div>
    </div>
</html>
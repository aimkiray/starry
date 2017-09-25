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
    <link href="${root}/resources/post/css/wysiwyg.css" rel="stylesheet" type="text/css">

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

                    <div class="top-post-wrapper">
                        <div class="top-post-content">
                            <span class="title-link">文章页</span>
                            <#--<div class="grey-rule"></div>-->
                            <div class="text-block">
                                page ${pageNumber} / ${allPageNum}
                            </div>
                        </div>
                    </div>

                <#list posts as post>
                    <div class="post-wrapper">
                        <div class="post-content">
                            <a class="title-link"
                               href="${root}/article/${post.postId}" target="_self">${post.postTitle}</a>
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

                        <div class="post-text-content wysiwyg">
                        <#--markdown格式原始文章-->
                            <div id="rawPost${post.postId}" style="display: none">${post.postType}</div>
                        <#--文章显示区域-->
                            <div class="paragraph" id="htmlPost${post.postId}"></div>
                        </div>

                    </div>
                    <input name="postId" type="hidden" value="${post.postId}">
                </#list>

                </div>

                <#--上一页-->
                <div <#if pageNumber == 1 >style="display: none"<#else>class="l-button-wrapper"</#if>><a class="button" href="${root}/page/${pageNumber - 1}">←&nbsp;上一页</a></div>
                <#--下一页-->
                <div <#if pageNumber == allPageNum >style="display: none"<#else>class="r-button-wrapper"</#if>><a class="button" href="${root}/page/${pageNumber + 1}">下一页&nbsp;→</a></div>

            <#--显示区域宽度过小时显示的内容-->
                <div class="sidebar-on-mobile">
                    <#include "side.ftl" >
                </div>
            </div>
        </div>
    </div>
</html>
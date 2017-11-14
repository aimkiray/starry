<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="mobile-web-app-capable" content="yes">
    <title>
        HackMD - Collaborative markdown notes
    </title>
    <link rel="icon" type="image/png" href="https://hackmd.io/favicon.png">
    <link rel="apple-touch-icon" href="https://hackmd.io/apple-touch-icon.png">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha256-916EbMg70RQy9LHiGkXzG8hSg9EdNy97GazNG/aiY1w=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha256-eZrrJcwDc/3uDhsdt61sL2oOBY362qM3lon1gyExkL0=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" integrity="sha256-3iu9jgsy9TpTwXKb7bNQzqWekRX7pPK+2OLj3R922fo=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/octicons/3.5.0/octicons.min.css" integrity="sha256-QiWfLIsCT02Sdwkogf6YMiQlj4NE84MKkzEMkZnMGdg=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.5.1/themes/prism.min.css" integrity="sha256-vtR0hSWRc3Tb26iuN2oZHt3KRUomwTufNIf5/4oeCyg=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.7.0/styles/github-gist.min.css" integrity="sha256-tAflq+ymku3Khs+I/WcAneIlafYgDiOQ9stIHH985Wo=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/emojify.js/1.1.0/css/basic/emojify.min.css" integrity="sha256-UOrvMOsSDSrW6szVLe8ZDZezBxh5IoIfgTwdNDgTjiU=" crossorigin="anonymous" />
    <style>
        @import url(https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400italic,600,600italic,300italic,300|Source+Serif+Pro|Source+Code+Pro:400,300,500&subset=latin,latin-ext);.markdown-body{font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica,Arial,sans-serif;font-size:16px;line-height:1.5;word-wrap:break-word}.markdown-body:after,.markdown-body:before{display:table;content:""}.markdown-body:after{clear:both}.markdown-body>:first-child{margin-top:0!important}.markdown-body>:last-child{margin-bottom:0!important}.markdown-body a:not([href]){color:inherit;text-decoration:none}.markdown-body .absent{color:#c00}.markdown-body .anchor{float:left;padding-right:4px;margin-left:-20px;line-height:1}.markdown-body .anchor:focus{outline:none}.markdown-body blockquote,.markdown-body dl,.markdown-body ol,.markdown-body p,.markdown-body pre,.markdown-body table,.markdown-body ul{margin-top:0;margin-bottom:16px}.markdown-body hr{height:.25em;padding:0;margin:24px 0;background-color:#e7e7e7;border:0}.markdown-body blockquote{padding:0 1em;color:#777;border-left:.25em solid #ddd}.markdown-body blockquote>:first-child{margin-top:0}.markdown-body blockquote>:last-child{margin-bottom:0}.markdown-body .loweralpha{list-style-type:lower-alpha}.markdown-body h1,.markdown-body h2,.markdown-body h3,.markdown-body h4,.markdown-body h5,.markdown-body h6{margin-top:24px;margin-bottom:16px;font-weight:600;line-height:1.25}.markdown-body h1 .octicon-link,.markdown-body h2 .octicon-link,.markdown-body h3 .octicon-link,.markdown-body h4 .octicon-link,.markdown-body h5 .octicon-link,.markdown-body h6 .octicon-link{color:#000;vertical-align:middle;visibility:hidden}.markdown-body h1:hover .anchor,.markdown-body h2:hover .anchor,.markdown-body h3:hover .anchor,.markdown-body h4:hover .anchor,.markdown-body h5:hover .anchor,.markdown-body h6:hover .anchor{text-decoration:none}.markdown-body h1:hover .anchor .octicon-link,.markdown-body h2:hover .anchor .octicon-link,.markdown-body h3:hover .anchor .octicon-link,.markdown-body h4:hover .anchor .octicon-link,.markdown-body h5:hover .anchor .octicon-link,.markdown-body h6:hover .anchor .octicon-link{visibility:visible}.markdown-body h1 code,.markdown-body h1 tt,.markdown-body h2 code,.markdown-body h2 tt,.markdown-body h3 code,.markdown-body h3 tt,.markdown-body h4 code,.markdown-body h4 tt,.markdown-body h5 code,.markdown-body h5 tt,.markdown-body h6 code,.markdown-body h6 tt{font-size:inherit}.markdown-body h1{font-size:2em}.markdown-body h1,.markdown-body h2{padding-bottom:.3em;border-bottom:1px solid #eee}.markdown-body h2{font-size:1.5em}.markdown-body h3{font-size:1.25em}.markdown-body h4{font-size:1em}.markdown-body h5{font-size:.875em}.markdown-body h6{font-size:.85em;color:#777}.markdown-body ol,.markdown-body ul{padding-left:2em}.markdown-body ol.no-list,.markdown-body ul.no-list{padding:0;list-style-type:none}.markdown-body ol ol,.markdown-body ol ul,.markdown-body ul ol,.markdown-body ul ul{margin-top:0;margin-bottom:0}.markdown-body li>p{margin-top:16px}.markdown-body li+li{margin-top:.25em}.markdown-body dl{padding:0}.markdown-body dl dt{padding:0;margin-top:16px;font-size:1em;font-style:italic;font-weight:700}.markdown-body dl dd{padding:0 16px;margin-bottom:16px}.markdown-body table{display:block;width:100%;overflow:auto;word-break:normal;word-break:keep-all}.markdown-body table th{font-weight:700}.markdown-body table td,.markdown-body table th{padding:6px 13px;border:1px solid #ddd}.markdown-body table tr{background-color:#fff;border-top:1px solid #ccc}.markdown-body table tr:nth-child(2n){background-color:#f8f8f8}.markdown-body img{max-width:100%;box-sizing:content-box;background-color:#fff}.markdown-body img[align=right]{padding-left:20px}.markdown-body img[align=left]{padding-right:20px}.markdown-body .emoji{max-width:none;vertical-align:text-top;background-color:transparent}.markdown-body span.frame{display:block;overflow:hidden}.markdown-body span.frame>span{display:block;float:left;width:auto;padding:7px;margin:13px 0 0;overflow:hidden;border:1px solid #ddd}.markdown-body span.frame span img{display:block;float:left}.markdown-body span.frame span span{display:block;padding:5px 0 0;clear:both;color:#333}.markdown-body span.align-center{display:block;overflow:hidden;clear:both}.markdown-body span.align-center>span{display:block;margin:13px auto 0;overflow:hidden;text-align:center}.markdown-body span.align-center span img{margin:0 auto;text-align:center}.markdown-body span.align-right{display:block;overflow:hidden;clear:both}.markdown-body span.align-right>span{display:block;margin:13px 0 0;overflow:hidden;text-align:right}.markdown-body span.align-right span img{margin:0;text-align:right}.markdown-body span.float-left{display:block;float:left;margin-right:13px;overflow:hidden}.markdown-body span.float-left span{margin:13px 0 0}.markdown-body span.float-right{display:block;float:right;margin-left:13px;overflow:hidden}.markdown-body span.float-right>span{display:block;margin:13px auto 0;overflow:hidden;text-align:right}.markdown-body code,.markdown-body tt{padding:0;padding-top:.2em;padding-bottom:.2em;margin:0;font-size:85%;background-color:rgba(0,0,0,.04);border-radius:3px}.markdown-body code:after,.markdown-body code:before,.markdown-body tt:after,.markdown-body tt:before{letter-spacing:-.2em;content:"\A0"}.markdown-body code br,.markdown-body tt br{display:none}.markdown-body del code{text-decoration:inherit}.markdown-body pre{word-wrap:normal}.markdown-body pre>code{padding:0;margin:0;font-size:100%;word-break:normal;white-space:pre;background:transparent;border:0}.markdown-body .highlight{margin-bottom:16px}.markdown-body .highlight pre{margin-bottom:0;word-break:normal}.markdown-body .highlight pre,.markdown-body pre{padding:16px;overflow:auto;font-size:85%;line-height:1.45;background-color:#f7f7f7;border-radius:3px}.markdown-body pre code,.markdown-body pre tt{display:inline;max-width:auto;padding:0;margin:0;overflow:visible;line-height:inherit;word-wrap:normal;background-color:transparent;border:0}.markdown-body pre code:after,.markdown-body pre code:before,.markdown-body pre tt:after,.markdown-body pre tt:before{content:normal}.markdown-body .csv-data td,.markdown-body .csv-data th{padding:5px;overflow:hidden;font-size:12px;line-height:1;text-align:left;white-space:nowrap}.markdown-body .csv-data .blob-line-num{padding:10px 8px 9px;text-align:right;background:#fff;border:0}.markdown-body .csv-data tr{border-top:0}.markdown-body .csv-data th{font-weight:700;background:#f8f8f8;border-top:0}.markdown-body kbd{display:inline-block;padding:3px 5px;font-size:11px;line-height:10px;color:#555;vertical-align:middle;background-color:#fcfcfc;border:1px solid #ccc;border-bottom-color:#bbb;border-radius:3px;box-shadow:inset 0 -1px 0 #bbb}.news .alert .markdown-body blockquote{padding:0 0 0 40px;border:0 none}.activity-tab .news .alert .commits,.activity-tab .news .markdown-body blockquote{padding-left:0}.task-list-item{list-style-type:none}.task-list-item label{font-weight:400}.task-list-item.enabled label{cursor:pointer}.task-list-item+.task-list-item{margin-top:3px}.task-list-item-checkbox{float:left;margin:.31em 0 .2em -1.3em!important;vertical-align:middle;cursor:default!important}.markdown-body{font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica Neue,Helvetica,Arial,sans-serif;padding-top:40px;padding-bottom:40px;max-width:758px;overflow:visible!important}.markdown-body pre{border:inherit!important}.markdown-body code{color:inherit!important}.markdown-body pre code .wrapper{display:-moz-inline-flex;display:-ms-inline-flex;display:-o-inline-flex;display:inline-flex}.markdown-body pre code .gutter{float:left;overflow:hidden;-webkit-user-select:none;user-select:none}.markdown-body pre code .gutter.linenumber{text-align:right;position:relative;display:inline-block;cursor:default;z-index:4;padding:0 8px 0 0;min-width:20px;box-sizing:content-box;color:#afafaf!important;border-right:3px solid #6ce26c!important}.markdown-body pre code .gutter.linenumber>span:before{content:attr(data-linenumber)}.markdown-body pre code .code{float:left;margin:0 0 0 16px}.markdown-body .gist .line-numbers{border-left:none;border-top:none;border-bottom:none}.markdown-body .gist .line-data{border:none}.markdown-body .gist table{border-spacing:0;border-collapse:inherit!important}.markdown-body code[data-gist-id]{background:none;padding:0}.markdown-body code[data-gist-id]:after,.markdown-body code[data-gist-id]:before{content:""}.markdown-body code[data-gist-id] .blob-num{border:unset}.markdown-body code[data-gist-id] table{overflow:unset;margin-bottom:unset}.markdown-body code[data-gist-id] table tr{background:unset}.markdown-body[dir=rtl] pre{direction:ltr}.markdown-body[dir=rtl] code{direction:ltr;unicode-bidi:embed}.markdown-body .alert>p{margin-bottom:0}.markdown-body pre.abc,.markdown-body pre.flow-chart,.markdown-body pre.graphviz,.markdown-body pre.mermaid,.markdown-body pre.sequence-diagram{text-align:center;background-color:inherit;border-radius:0;white-space:inherit}.markdown-body pre.abc>code,.markdown-body pre.flow-chart>code,.markdown-body pre.graphviz>code,.markdown-body pre.mermaid>code,.markdown-body pre.sequence-diagram>code{text-align:left}.markdown-body pre.abc>svg,.markdown-body pre.flow-chart>svg,.markdown-body pre.graphviz>svg,.markdown-body pre.mermaid>svg,.markdown-body pre.sequence-diagram>svg{max-width:100%;height:100%}.markdown-body pre>code.wrap{white-space:pre-wrap;white-space:-moz-pre-wrap;white-space:-pre-wrap;white-space:-o-pre-wrap;word-wrap:break-word}.markdown-body .alert>p,.markdown-body .alert>ul{margin-bottom:0}.vimeo,.youtube{cursor:pointer;display:table;text-align:center;background-position:50%;background-repeat:no-repeat;background-size:contain;background-color:#000;overflow:hidden}.vimeo,.youtube{position:relative;width:100%}.youtube{padding-bottom:56.25%}.vimeo img{width:100%;object-fit:contain;z-index:0}.youtube img{object-fit:cover;z-index:0}.vimeo iframe,.youtube iframe,.youtube img{width:100%;height:100%;position:absolute;top:0;left:0}.vimeo iframe,.youtube iframe{vertical-align:middle;z-index:1}.vimeo .icon,.youtube .icon{position:absolute;height:auto;width:auto;top:50%;left:50%;transform:translate(-50%,-50%);color:#fff;opacity:.3;transition:opacity .2s;z-index:0}.vimeo:hover .icon,.youtube:hover .icon{opacity:.6;transition:opacity .2s}.slideshare .inner,.speakerdeck .inner{position:relative;width:100%}.slideshare .inner iframe,.speakerdeck .inner iframe{position:absolute;top:0;bottom:0;left:0;right:0;width:100%;height:100%}.MJX_Assistive_MathML{display:none}.ui-infobar{position:relative;z-index:2;max-width:758px;margin-top:25px;margin-bottom:-25px;color:#777}.ui-toc{position:fixed;bottom:20px;z-index:10000}.ui-toc-label{opacity:.3;background-color:#ccc;border:none;transition:opacity .2s}.ui-toc .open .ui-toc-label{opacity:1;color:#fff;transition:opacity .2s}.ui-toc-label:focus{opacity:.3;background-color:#ccc;color:#000}.ui-toc-label:hover{opacity:1;background-color:#ccc;transition:opacity .2s}.ui-toc-dropdown{margin-top:23px;margin-bottom:20px;padding-left:10px;padding-right:10px;max-width:45vw;width:25vw;max-height:70vh;overflow:auto;text-align:inherit}.ui-toc-dropdown>.toc{max-height:calc(70vh - 100px);overflow:auto}.ui-toc-dropdown[dir=rtl] .nav{padding-right:0;letter-spacing:.0029em}.ui-toc-dropdown a{overflow:hidden;text-overflow:ellipsis;white-space:pre}.ui-toc-dropdown .nav>li>a{display:block;padding:4px 20px;font-size:13px;font-weight:500;color:#767676}.ui-toc-dropdown .nav>li:first-child:last-child > ul,.ui-toc-dropdown .toc.expand ul{display:block}.ui-toc-dropdown .nav>li>a:focus,.ui-toc-dropdown .nav>li>a:hover{padding-left:19px;color:#000;text-decoration:none;background-color:transparent;border-left:1px solid #000}.ui-toc-dropdown[dir=rtl] .nav>li>a:focus,.ui-toc-dropdown[dir=rtl] .nav>li>a:hover{padding-right:19px;border-left:none;border-right:1px solid #000}.ui-toc-dropdown .nav>.active:focus>a,.ui-toc-dropdown .nav>.active:hover>a,.ui-toc-dropdown .nav>.active>a{padding-left:18px;font-weight:700;color:#000;background-color:transparent;border-left:2px solid #000}.ui-toc-dropdown[dir=rtl] .nav>.active:focus>a,.ui-toc-dropdown[dir=rtl] .nav>.active:hover>a,.ui-toc-dropdown[dir=rtl] .nav>.active>a{padding-right:18px;border-left:none;border-right:2px solid #000}.ui-toc-dropdown .nav .nav{display:none;padding-bottom:10px}.ui-toc-dropdown .nav>.active>ul{display:block}.ui-toc-dropdown .nav .nav>li>a{padding-top:1px;padding-bottom:1px;padding-left:30px;font-size:12px;font-weight:400}.ui-toc-dropdown[dir=rtl] .nav .nav>li>a{padding-right:30px}.ui-toc-dropdown .nav .nav>li>ul>li>a{padding-top:1px;padding-bottom:1px;padding-left:40px;font-size:12px;font-weight:400}.ui-toc-dropdown[dir=rtl] .nav .nav>li>ul>li>a{padding-right:40px}.ui-toc-dropdown .nav .nav>li>a:focus,.ui-toc-dropdown .nav .nav>li>a:hover{padding-left:29px}.ui-toc-dropdown[dir=rtl] .nav .nav>li>a:focus,.ui-toc-dropdown[dir=rtl] .nav .nav>li>a:hover{padding-right:29px}.ui-toc-dropdown .nav .nav>li>ul>li>a:focus,.ui-toc-dropdown .nav .nav>li>ul>li>a:hover{padding-left:39px}.ui-toc-dropdown[dir=rtl] .nav .nav>li>ul>li>a:focus,.ui-toc-dropdown[dir=rtl] .nav .nav>li>ul>li>a:hover{padding-right:39px}.ui-toc-dropdown .nav .nav>.active:focus>a,.ui-toc-dropdown .nav .nav>.active:hover>a,.ui-toc-dropdown .nav .nav>.active>a{padding-left:28px;font-weight:500}.ui-toc-dropdown[dir=rtl] .nav .nav>.active:focus>a,.ui-toc-dropdown[dir=rtl] .nav .nav>.active:hover>a,.ui-toc-dropdown[dir=rtl] .nav .nav>.active>a{padding-right:28px}.ui-toc-dropdown .nav .nav>.active>.nav>.active:focus>a,.ui-toc-dropdown .nav .nav>.active>.nav>.active:hover>a,.ui-toc-dropdown .nav .nav>.active>.nav>.active>a{padding-left:38px;font-weight:500}.ui-toc-dropdown[dir=rtl] .nav .nav>.active>.nav>.active:focus>a,.ui-toc-dropdown[dir=rtl] .nav .nav>.active>.nav>.active:hover>a,.ui-toc-dropdown[dir=rtl] .nav .nav>.active>.nav>.active>a{padding-right:38px}.markdown-body[lang^=ja]{font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica Neue,Helvetica,Arial,Hiragino Kaku Gothic Pro,\\30D2\30E9\30AE\30CE\89D2\30B4 Pro W3,Osaka,Meiryo,\\30E1\30A4\30EA\30AA,MS Gothic,"\FF2D\FF33   \30B4\30B7\30C3\30AF",sans-serif}.ui-toc-dropdown[lang^=ja]{font-family:Source Sans Pro,Helvetica,Arial,Meiryo UI,MS PGothic,"\FF2D\FF33   \FF30\30B4\30B7\30C3\30AF",sans-serif}.markdown-body[lang=zh-tw]{font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica Neue,Helvetica,Arial,PingFang TC,Microsoft JhengHei,\\5FAE\8EDF\6B63\9ED1,sans-serif}.ui-toc-dropdown[lang=zh-tw]{font-family:Source Sans Pro,Helvetica,Arial,Microsoft JhengHei UI,\\5FAE\8EDF\6B63\9ED1UI,sans-serif}.markdown-body[lang=zh-cn]{font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica Neue,Helvetica,Arial,PingFang SC,Microsoft YaHei,\\5FAE\8F6F\96C5\9ED1,sans-serif}.ui-toc-dropdown[lang=zh-cn]{font-family:Source Sans Pro,Helvetica,Arial,Microsoft YaHei UI,\\5FAE\8F6F\96C5\9ED1UI,sans-serif}.ui-affix-toc{position:fixed;top:0;max-width:15vw;max-height:70vh;overflow:auto}.back-to-top,.expand-toggle,.go-to-bottom{display:block;padding:4px 10px;margin-top:10px;margin-left:10px;font-size:12px;font-weight:500;color:#999}.back-to-top:focus,.back-to-top:hover,.expand-toggle:focus,.expand-toggle:hover,.go-to-bottom:focus,.go-to-bottom:hover{color:#563d7c;text-decoration:none}.back-to-top,.go-to-bottom{margin-top:0}.ui-user-icon{width:20px;height:20px;display:block;border-radius:3px;margin-top:2px;margin-bottom:2px;margin-right:5px;background-position:50%;background-repeat:no-repeat;background-size:contain}.ui-user-icon.small{width:18px;height:18px;display:inline-block;vertical-align:middle;margin:0 0 .2em}.ui-infobar>small>span{line-height:22px}.ui-infobar>small .dropdown{display:inline-block}.ui-infobar>small .dropdown a:focus,.ui-infobar>small .dropdown a:hover{text-decoration:none}.unselectable{-moz-user-select:none;-webkit-user-select:none;-o-user-select:none;user-select:none}@media print{blockquote,div,img,pre,table{page-break-inside:avoid!important}a[href]:after{font-size:12px!important}}.markdown-body.slides{position:relative;z-index:1;color:#222}.markdown-body.slides:before{content:"";display:block;position:absolute;top:0;left:0;right:0;bottom:0;z-index:-1;background-color:currentColor;box-shadow:0 0 0 50vw}.markdown-body.slides section[data-markdown]{position:relative;margin-bottom:1.5em;background-color:#fff;text-align:center}.markdown-body.slides section[data-markdown] code{text-align:left}.markdown-body.slides section[data-markdown]:before{content:"";display:block;padding-bottom:56.23%}.markdown-body.slides section[data-markdown]>div:first-child{position:absolute;top:50%;left:1em;right:1em;transform:translateY(-50%);max-height:100%;overflow:hidden}.markdown-body.slides section[data-markdown]>ul{display:inline-block}.markdown-body.slides>section>section+section:after{content:"";position:absolute;top:-1.5em;right:1em;height:1.5em;border:3px solid #777}body{font-smoothing:subpixel-antialiased!important;-webkit-font-smoothing:subpixel-antialiased!important;-moz-osx-font-smoothing:auto!important;text-shadow:0 0 1em transparent,1px 1px 1.2px rgba(0,0,0,.004);-webkit-overflow-scrolling:touch;font-family:Source Sans Pro,Helvetica,Arial,sans-serif;letter-spacing:.025em}.focus,:focus{outline:none!important}::-moz-focus-inner{border:0!important}body.modal-open{overflow-y:auto;padding-right:0!important}
    </style>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" integrity="sha256-3Jy/GbSLrg0o9y5Z5n1uw0qxZECH7C6OQpVBgNFYa0g=" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js" integrity="sha256-g6iAfvZp+nDQ2TdTR/VVKJf3bGro4ub5fvWSWVRi2NE=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/es5-shim/4.5.9/es5-shim.min.js" integrity="sha256-8E4Is26QH0bD52WoQpcB+R/tcWQtpzlCojrybUd7Mxo=" crossorigin="anonymous"></script>
    <![endif]-->
</head>

<body>
    <div id="doc" class="markdown-body container-fluid"><h2 id="联系方式"><a class="anchor hidden-xs" href="#联系方式" title="联系方式"><span class="octicon octicon-link"></span></a>联系方式</h2><ul>
<li>
<p>手机：18557513332</p>
</li>
<li>
<p>Email：root@meowwoo.com</p>
</li>
<li>
<p>QQ：1127076792</p>
</li>
</ul><h2 id="个人信息"><a class="anchor hidden-xs" href="#个人信息" title="个人信息"><span class="octicon octicon-link"></span></a>个人信息</h2><ul>
<li>
<p>张舜/男/1995.11</p>
</li>
<li>
<p>浙江万里学院/本科/大三休学中</p>
</li>
<li>
<p>工作年限：应届</p>
</li>
<li>
<p>期望职位：Java Web</p>
</li>
<li>
<p>期望城市：杭州</p>
</li>
</ul><h2 id="项目经历"><a class="anchor hidden-xs" href="#项目经历" title="项目经历"><span class="octicon octicon-link"></span></a>项目经历</h2><h3 id="starry-博客系统"><a class="anchor hidden-xs" href="#starry-博客系统" title="starry-博客系统"><span class="octicon octicon-link"></span></a>Starry 博客系统</h3><p>Code &amp; Demo: <a href="https://github.com/nekuata/starry" target="_blank">https://github.com/nekuata/starry</a></p><blockquote>
<p>自用博客系统，快速，稳定，安全；有详细的说明文档和代码注释，用于学习主流框架和练习 Java 基础，积累项目经验。现已开源并附有线上 Demo，主要特点如下。</p>
</blockquote><ul>
<li>采用主流的 SSM(Spring, Spring MVC, MyBatis) 框架</li>
<li>具备完善的 文章/标签/用户/角色/权限 管理系统，开箱即用</li>
<li>Freemarker &amp; CSS 实现优雅的博客界面</li>
<li>JSP &amp; Bootstrap 实现的后台界面</li>
<li>jQuery Ajax &amp; Spring MVC 配合实现图片上传</li>
<li>自主设计的权限管理模块，有用户友好的操作界面</li>
<li>RESTful 风格 API，简洁易懂</li>
<li>防御 XSS 和 SQL 注入</li>
<li>Linux 下项目自动化部署，通过 Git 和 Shell 脚本实现</li>
</ul><h3 id="sgroup-订单管理系统"><a class="anchor hidden-xs" href="#sgroup-订单管理系统" title="sgroup-订单管理系统"><span class="octicon octicon-link"></span></a>Sgroup 订单管理系统</h3><p>Code: <a href="https://github.com/nekuata/sgroup" target="_blank">https://github.com/nekuata/sgroup</a></p><blockquote>
<p>本人第一个 Java web 项目，用于巩固基础而作。在此过程中本人充分练习了 Java 常用的设计模式和 J2EE 基本知识，熟悉了 MVC 架构模式，初步学习了 ES5 语法以及 HTML5 和 CSS3 常用标签属性，并加强了独立解决问题的能力。项目已完成，主要特点如下。</p>
</blockquote><ul>
<li>采用 MVC 架构，有高可维护性与可扩展性设计</li>
<li>JDBC 实现数据库的 CRUD</li>
<li>Filter 实现登陆验证，Listener 实现日志记录</li>
<li>JSP &amp; Servlet 实现用户交互</li>
<li>完整的 产品/类别/订单/购物车/用户 管理系统</li>
<li>原生 JS 实现产品 &amp; 类别的单页操作和行内修改效果</li>
<li>jQuery 实现购物车相关操作和提交前的数据库验证操作</li>
<li>Ajax 异步请求数据，缓解服务端压力</li>
</ul><h3 id="starry-gallery-资源管理系统"><a class="anchor hidden-xs" href="#starry-gallery-资源管理系统" title="starry-gallery-资源管理系统"><span class="octicon octicon-link"></span></a>Starry-gallery 资源管理系统</h3><p>Code: <a href="https://github.com/nekuata/starry-gallery" target="_blank">https://github.com/nekuata/starry-gallery</a></p><blockquote>
<p>熟练掌握 SSM 框架后，本人开始尝试一些新技术，用于提高开发效率或提升系统性能。此项目是由 starry 博客系统的资源管理模块拆分重构而来，主要提供文件上传，管理，生成直链等功能，也可作为轻量级网盘使用。重构以 Spring boot 为主，辅以 Shiro 权限管理，HikariCP 数据库连接池，并尝试整合 Redis 实现缓存操作。项目处于 development 阶段，主要特点如下。</p>
</blockquote><ul>
<li>基于 Spring boot 快速开发</li>
<li>使用 Redis 对首页图片进行缓存存储，提高响应速度</li>
<li>引入 Shiro 权限管理框架，安全可靠</li>
<li>实现完整的 RESTful API，基于 HTTP/JSON 传输数据</li>
</ul><h2 id="技能"><a class="anchor hidden-xs" href="#技能" title="技能"><span class="octicon octicon-link"></span></a>技能</h2><ul>
<li><strong>Java</strong>：熟悉Java语法，编码规范，见名知意；了解 Util 包下常用工具类，了解常用集合框架的原理并能熟练使用；了解 Java 的泛类和反射机制，以此写过 Service 父类实现通用 CRUD；熟悉 I/O 流和异常处理，了解多线程和同步机制；会用 Java 实现经典算法（面向 Google）</li>
<li><strong>网页</strong>：熟悉 HTML5 常用标签和属性；熟悉 CSS 常用属性语法，熟练使用原生 CSS 定位元素，了解 CSS3 动画</li>
<li><strong>JavaScript</strong>：了解 ES5，熟悉原生 DOM 操作；熟悉类型转换，比如 Object 类型和 JSON 字符串互转；用过原生 Ajax 实现文件上传；<s>精通 Node.js 的 Hello World 写法</s>（正式版见PDF）</li>
<li><strong>C</strong>：高中时的入门语言，大一上学期裸考过了二级 C 语言；数学建模大赛用 C 实现过背包算法解决实际问题；写过简易飞控程序</li>
<li><strong>数据库</strong>：熟悉 MySQL/MariaDB，用过 Oracle/H2/Redis；熟悉常用 SQL 语法</li>
<li><strong>软件</strong>：主力 IDEA/VS Code，用过大部分 IDE</li>
<li><strong>后端框架</strong>：熟悉 Spring 大部分框架的使用，比较偏爱 Spring Boot，了解 Spring MVC 的基本原理；用过 Struts</li>
<li><strong>开源工具</strong>：主力 ORM 是 MyBatis/Data JPA，用过 Hibernate；前端模板是 Freemarker，在项目中用过 Bootstrap 3/4，熟悉 jQuery 语法</li>
<li><strong>版本管理</strong>：Git/SVN</li>
<li><strong>系统</strong>：超过3年 Linux 使用经验</li>
<li><strong>其他</strong>：<s>擅长修电脑</s></li>
</ul><h2 id="获奖情况"><a class="anchor hidden-xs" href="#获奖情况" title="获奖情况"><span class="octicon octicon-link"></span></a>获奖情况</h2><ul>
<li>2014-2015 学年电气电子工程分院三等奖学金</li>
<li>2015-2016 学年电气电子工程分院三等奖学金</li>
<li>2015 年全国大学生数学建模竞赛省三等奖</li>
<li>申请专利 *1（<a href="https://github.com/nekuata/resume/blob/master/patent/patent.pdf" target="_blank">一种可调节式 LED 灯</a>）</li>
<li>发表论文 *1（一种 PWM 调光 LED 照明电路设计）</li>
</ul><h2 id="自我评价"><a class="anchor hidden-xs" href="#自我评价" title="自我评价"><span class="octicon octicon-link"></span></a>自我评价</h2><ul>
<li>乐于自学，边学边用，面向 Google 编程，擅长搜寻并独立解决问题</li>
<li>喜欢学习研究新技术，并能迅速运用到项目中</li>
<li>工作积极负责</li>
<li>人缘好，擅长换位思考，知错必改</li>
<li>乐于进行团队沟通交流，分享知识，与团队成员共同发展</li>
</ul></div>
    <div class="ui-toc dropup unselectable hidden-print" style="display:none;">
        <div class="pull-right dropdown">
            <a id="tocLabel" class="ui-toc-label btn btn-default" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" title="Table of content">
                <i class="fa fa-bars"></i>
            </a>
            <ul id="ui-toc" class="ui-toc-dropdown dropdown-menu" aria-labelledby="tocLabel">
                <div class="toc"><ul class="nav"><li class=""><a href="#联系方式">联系方式</a></li><li class=""><a href="#个人信息">个人信息</a></li><li class=""><a href="#项目经历">项目经历</a><ul class="nav"><li class=""><a href="#starry-博客系统">Starry 博客系统</a></li><li class=""><a href="#sgroup-订单管理系统">Sgroup 订单管理系统</a></li><li><a href="#starry-gallery-资源管理系统">Starry-gallery 资源管理系统</a></li></ul></li><li><a href="#技能">技能</a></li><li><a href="#获奖情况">获奖情况</a></li><li><a href="#自我评价">自我评价</a></li></ul></div><div class="toc-menu"><a class="expand-toggle" href="#">Expand all</a><a class="back-to-top" href="#">Back to top</a><a class="go-to-bottom" href="#">Go to bottom</a></div>
            </ul>
        </div>
    </div>
    <div id="ui-toc-affix" class="ui-affix-toc ui-toc-dropdown unselectable hidden-print" data-spy="affix" style="top:17px;display:none;"  >
        <div class="toc"><ul class="nav"><li class=""><a href="#联系方式">联系方式</a></li><li class=""><a href="#个人信息">个人信息</a></li><li class=""><a href="#项目经历">项目经历</a><ul class="nav"><li class=""><a href="#starry-博客系统">Starry 博客系统</a></li><li class=""><a href="#sgroup-订单管理系统">Sgroup 订单管理系统</a></li><li><a href="#starry-gallery-资源管理系统">Starry-gallery 资源管理系统</a></li></ul></li><li><a href="#技能">技能</a></li><li><a href="#获奖情况">获奖情况</a></li><li><a href="#自我评价">自我评价</a></li></ul></div><div class="toc-menu"><a class="expand-toggle" href="#">Expand all</a><a class="back-to-top" href="#">Back to top</a><a class="go-to-bottom" href="#">Go to bottom</a></div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha256-U5ZEeKfGNOja007MMD3YBI0A3OSZOQbeG6z2f2Y0hu8=" crossorigin="anonymous" defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gist-embed/2.6.0/gist-embed.min.js" integrity="sha256-KyF2D6xPIJUW5sUDSs93vWyZm+1RzIpKCexxElmxl8g=" crossorigin="anonymous" defer></script>
    <script>
        var markdown = $(".markdown-body");
        //smooth all hash trigger scrolling
        function smoothHashScroll() {
            var hashElements = $("a[href^='#']").toArray();
            for (var i = 0; i < hashElements.length; i++) {
                var element = hashElements[i];
                var $element = $(element);
                var hash = element.hash;
                if (hash) {
                    $element.on('click', function (e) {
                        // store hash
                        var hash = this.hash;
                        if ($(hash).length <= 0) return;
                        // prevent default anchor click behavior
                        e.preventDefault();
                        // animate
                        $('body, html').stop(true, true).animate({
                            scrollTop: $(hash).offset().top
                        }, 100, "linear", function () {
                            // when done, add hash to url
                            // (default click behaviour)
                            window.location.hash = hash;
                        });
                    });
                }
            }
        }

        smoothHashScroll();
        var toc = $('.ui-toc');
        var tocAffix = $('.ui-affix-toc');
        var tocDropdown = $('.ui-toc-dropdown');
        //toc
        tocDropdown.click(function (e) {
            e.stopPropagation();
        });

        var enoughForAffixToc = true;

        function generateScrollspy() {
            $(document.body).scrollspy({
                target: ''
            });
            $(document.body).scrollspy('refresh');
            if (enoughForAffixToc) {
                toc.hide();
                tocAffix.show();
            } else {
                tocAffix.hide();
                toc.show();
            }
            $(document.body).scroll();
        }

        function windowResize() {
            //toc right
            var paddingRight = parseFloat(markdown.css('padding-right'));
            var right = ($(window).width() - (markdown.offset().left + markdown.outerWidth() - paddingRight));
            toc.css('right', right + 'px');
            //affix toc left
            var newbool;
            var rightMargin = (markdown.parent().outerWidth() - markdown.outerWidth()) / 2;
            //for ipad or wider device
            if (rightMargin >= 133) {
                newbool = true;
                var affixLeftMargin = (tocAffix.outerWidth() - tocAffix.width()) / 2;
                var left = markdown.offset().left + markdown.outerWidth() - affixLeftMargin;
                tocAffix.css('left', left + 'px');
            } else {
                newbool = false;
            }
            if (newbool != enoughForAffixToc) {
                enoughForAffixToc = newbool;
                generateScrollspy();
            }
        }
        $(window).resize(function () {
            windowResize();
        });
        $(document).ready(function () {
            windowResize();
            generateScrollspy();
        });

        //remove hash
        function removeHash() {
            window.location.hash = '';
        }

        var backtotop = $('.back-to-top');
        var gotobottom = $('.go-to-bottom');

        backtotop.click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            if (scrollToTop)
                scrollToTop();
            removeHash();
        });
        gotobottom.click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            if (scrollToBottom)
                scrollToBottom();
            removeHash();
        });

        var toggle = $('.expand-toggle');
        var tocExpand = false;

        checkExpandToggle();
        toggle.click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            tocExpand = !tocExpand;
            checkExpandToggle();
        })

        function checkExpandToggle () {
            var toc = $('.ui-toc-dropdown .toc');
            var toggle = $('.expand-toggle');
            if (!tocExpand) {
                toc.removeClass('expand');
                toggle.text('Expand all');
            } else {
                toc.addClass('expand');
                toggle.text('Collapse all');
            }
        }

        function scrollToTop() {
            $('body, html').stop(true, true).animate({
                scrollTop: 0
            }, 100, "linear");
        }

        function scrollToBottom() {
            $('body, html').stop(true, true).animate({
                scrollTop: $(document.body)[0].scrollHeight
            }, 100, "linear");
        }
    </script>
</body>

</html>

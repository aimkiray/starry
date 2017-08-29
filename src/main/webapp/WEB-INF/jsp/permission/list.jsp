<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/8/28
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> ZTREE DEMO - Simple Data</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${root}/css/ztree/demo.css" type="text/css">
    <link rel="stylesheet" href="${root}/css/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${root}/js/ztree/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${root}/js/ztree/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${root}/js/ztree/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${root}/js/ztree/jquery.ztree.exedit.js"></script>
    <script type="text/javascript">
        var setting = {
            check: {
                enable: true,
                chkStyle: "checkbox",
                chkboxType: {"Y": "ps", "N": "ps"}
            },
            edit: {
                enable: true
            },
            view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            data: {
                key: {
                    name: "permissionName"
                },
                simpleData: {
                    enable: true,
                    idKey: "permissionId",
                    pIdKey: "parentId",
                    rootPId: 0
                }
            }
        };

        $(document).ready(function () {
            $.ajax({
                type: "post",
                url: "/permission/all.do",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $.fn.zTree.init($("#treeDemo"), setting, data);
                    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                    treeObj.expandAll(true);
                },
                error: function () {
                    alert("通信失败！");
                }
            });
            $("#btn_get_checked").click(function () {
                var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                var nodes = treeObj.getCheckedNodes(true);
                var permissionIds = "";
                if (nodes != null) {
                    for (var i = 0; i < nodes.length; i++) {
                        if (i == 0) {
                            permissionIds = nodes[i].permissionId;
                        } else {
                            permissionIds = permissionIds + "," + nodes[i].permissionId;

                        }
                    }
                    $.ajax({
                        type: "post",
                        url: "/permission/dispatcher.do",
                        data: {
                          "permissionIds" : permissionIds,
                          "roleId" : "1"
                        },
                        dataType: "json",
                        cache: false,
                        success: function (data) {
                            $.fn.zTree.init($("#treeDemo"), setting, data);
                            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                            treeObj.expandAll(true);
                        },
                        error: function () {
                            alert("通信失败！");
                        }
                    });
                }

            })
        });
    </script>
</head>

<body>
<div class="content_wrap">
    <div class="left">
        <ul id="treeDemo" class="ztree"></ul>
        <button id="btn_get_checked">提交</button>
    </div>
    <div class="right">

    </div>
</div>
</body>
</html>
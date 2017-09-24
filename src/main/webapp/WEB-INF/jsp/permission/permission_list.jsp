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
    <title>权限管理</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>

    <%--bootstrap--%>
    <link type="text/css" rel="stylesheet" href="${root}/resources/bootstrap-3.0/css/bootstrap.min.css">
    <%--datetimepicker--%>
    <link type="text/css" rel="stylesheet"
          href="${root}/resources/bootstrap-3.0/extension/datetimepicker/css/bootstrap-datetimepicker.min.css">
    <%--datatables--%>
    <link type="text/css" rel="stylesheet" href="${root}/resources/dataTables/css/dataTables.bootstrap.min.css">
    <%--awesome--%>
    <link type="text/css" rel="stylesheet" href="${root}/resources/font-awesome-4.7.0/css/font-awesome.min.css">
    <%--ztree--%>
    <link type="text/css" rel="stylesheet" href="${root}/resources/ztree/css/awesome.css">

    <%--jquery--%>
    <script src="${root}/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <%--bootstrap--%>
    <script src="${root}/resources/bootstrap-3.0/js/bootstrap.min.js" type="text/javascript"></script>
    <%--bootbox--%>
    <script src="${root}/resources/bootstrap-3.0/extension/bootbox/bootbox.min.js" type="text/javascript"></script>
    <%--datetimepicker--%>
    <script src="${root}/resources/bootstrap-3.0/extension/datetimepicker/js/bootstrap-datetimepicker.min.js"
            type="text/javascript"></script>
    <script src="${root}/resources/bootstrap-3.0/extension/datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"
            type="text/javascript"></script>
    <%--dataTables--%>
    <script src="${root}/resources/dataTables/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${root}/resources/dataTables/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <%--ztree--%>
    <script type="text/javascript" src="${root}/resources/ztree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${root}/resources/ztree/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${root}/resources/ztree/js/jquery.ztree.exedit.js"></script>

    <script type="text/javascript">
        var setting = {
            view: {
                expandSpeed: "",
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            edit: {
                enable: true
            },
            callback: {
                beforeEditName: zTreeBeforeEditName,
                beforeRemove: zTreeBeforeRemove,
                beforeDrop: zTreeBeforeDrop
            },
            async: {
                enable: true,
                url: "/permission/list",
                autoParam: ["permissionId=parentId"]
//                autoParam:["permissionId", "permissionName", "parentId"],
//                otherParam:{"otherParam":"zTreeAsyncTest"},
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

        //        拖拽调整父权限
        function zTreeBeforeDrop(treeId, treeNodes, targetNode, moveType) {
            var permissionId = treeNodes[0].permissionId;
            var oldParentId = treeNodes[0].parentId;
            var parentId = targetNode == null ? oldParentId : targetNode.permissionId;
            $.ajax({
                url: "/permission/update/drop",
                type: "post",
                data: {
                    "permissionId": permissionId,
                    "oldParentId": oldParentId,
                    "parentId": parentId
                },
                dataType: "json",
                success: function (data) {
                    if (data > 0) {
                        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                        zTree.reAsyncChildNodes(null, "refresh");
                        $("#manager_right").html("<div class='alert alert-success alert-dismissible' role='alert'>" +
                            "<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>" +
                            "<strong>Lucky!</strong> 修改成功！" +
                            "</div>");
                    } else {
                        alert("删除失败！");
                    }
                },
                error: function () {
                    alert("通信失败！")
                }
            });
            return false;
        };

        //        删除界面
        function zTreeBeforeRemove(treeId, treeNode) {
            var permissionId = treeNode.permissionId;
            var tId = treeNode.tId;
            var parentPermissionId = treeNode.getParentNode() == null ? 0 : treeNode.getParentNode().permissionId;
            if (treeNode.isParent) {
                alert("不能删除父权限！");
            } else {
                $.ajax({
                    url: "/permission/del",
                    type: "post",
                    data: {
                        "permissionId": permissionId,
                        "tId": tId,
                        "parentPermissionId": parentPermissionId
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.result > 0) {
                            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                            /*if (data.message == 0) {
                                zTree.reAsyncChildNodes(null, "refresh");
                            } else if (data.message == 1) {
                                zTree.reAsyncChildNodes(treeNode.getParentNode(), "refresh");
                            } else {
                                zTree.reAsyncChildNodes(treeNode.getParentNode().getParentNode(), "refresh");
                            }*/
                            zTree.reAsyncChildNodes(null, "refresh");
                            $("#manager_right").html("<div class='alert alert-success alert-dismissible' role='alert'>" +
                                "<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>" +
                                "<strong>Lucky!</strong> 删除成功！" +
                                "</div>");
                        } else {
                            alert("删除失败！");
                        }
                    },
                    error: function () {
                        alert("通信失败！")
                    }
                });
            }
            return false;
        }

        //        修改界面
        function zTreeBeforeEditName(treeId, treeNode) {
            var permissionId = treeNode.permissionId;
            var tId = treeNode.tId;
            $.ajax({
                url: "/permission/update/page",
                type: "post",
                data: {
                    "permissionId": permissionId,
                    "tId": tId
                },
                dataType: "text",
                success: function (data) {
                    $("#manager_right").html(data);
                }
            });
            return false;
        }

        function beforeRemove(treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.selectNode(treeNode);
            return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
        }

        function beforeRename(treeId, treeNode, newName) {
            if (newName.length == 0) {
                setTimeout(function () {
                    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                    zTree.cancelEditName();
                    alert("节点名称不能为空.");
                }, 0);
                return false;
            }
            return true;
        }

        var newCount = 1;

        function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_" + treeNode.tId);
            if (btn) btn.bind("click", function () {
                var parentId = treeNode.permissionId;
                var tId = treeNode.tId;
                $.ajax({
                    url: "/permission/add/page",
                    type: "post",
                    data: {
                        "parentId": parentId,
                        "tId": tId
                    },
                    dataType: "text",
                    success: function (data) {
                        $("#manager_right").html(data);
                    }
                });
                return false;
            });
        };

        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_" + treeNode.tId).unbind().remove();
        };

        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo"), setting);

            // 新增父节点
            $("#btn_add_parent").click(function () {
                var parentId = 0;
                // 随便起的名字
                var tId = "sb1";
                $.ajax({
                    url: "/permission/add/page",
                    type: "post",
                    data: {
                        "parentId": parentId,
                        "tId": tId
                    },
                    dataType: "text",
                    success: function (data) {
                        $("#manager_right").html(data);
                    }
                });
            })
        });
    </script>
</head>

<body>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-sm-3">
            <ul id="treeDemo" class="ztree"></ul>
            <button class="btn bottom-left" id="btn_add_parent">添加父节点</button>
        </div>
        <div class="col-sm-9" id="manager_right">
        </div>
    </div>
</div>
</body>
</html>

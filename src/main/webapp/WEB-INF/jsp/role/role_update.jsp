<%--
  Created by IntelliJ IDEA.
  User: nekuata
  Date: 2017/7/21
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>进化</title>
</head>
<script>
    var setting = {
        check: {
            enable: true,
            chkStyle: "checkbox",
            chkboxType: {"Y": "ps", "N": "s"}
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
            url: "/role/permission/list/"+$("#roleId").val(),
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

        $("#btn_update_role").click(function () {
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
//                添加权限ID数组到表单中
                $("#permissionIds").val(permissionIds);
//                提交表单
                $.ajax({
                    url: "/role/update",
                    cache: false, // 禁用缓存
                    type: "post",
                    data: $("#uploadForm").serialize(),
                    dataType: "json",
                    success: function (data) {
                        if (data > 0) {
                            roleTable().Init.ajax.reload();
                            $(".bootbox-close-button").click();
                        } else {
                            alert("修改失败");
                            $(".bootbox-close-button").click();
                        }
                    },
                    error: function () {
                        alert("通信失败");
                        $(".bootbox-close-button").click();
                    }
                });
            }
        });

        $(".form_datetime").datetimepicker({
            format: "yyyy-mm-dd hh:ii:ss",
            autoclose: true,
            todayBtn: true
        });
    });
</script>
<body>
<c:set var="role" value="${requestScope.role}" />

<%--选择权限并添加到form的隐藏域--%>
<div class="container-fluid">
    <div class="row clearfix">

        <div class="col-sm-7 column">
            <form id="uploadForm" method="post">
                <input type="hidden" name="roleId" id="roleId" value="${role.roleId}">
                <input type="hidden" name="permissionIds" id="permissionIds">
                <div class="form-group">
                    <label for="roleName">名称</label>
                    <input type="text" class="form-control" id="roleName" name="roleName" value="${role.roleName}" placeholder="君の名は。">
                </div>
                <div class="form-group">
                    <label for="roleInfo">详情</label>
                    <input type="text" class="form-control" id="roleInfo" name="roleInfo" value="${role.roleInfo}" placeholder="详情">
                </div>
                <button type="button" id="btn_update_role" class="btn btn-default">提交</button>
            </form>
        </div>

        <div class="col-sm-5 column">
            <div class="zTreeDemoBackground col-sm-4">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
            <div class="col-sm-8" id="manager_right">

            </div>
        </div>

    </div>
</div>
</body>
</html>

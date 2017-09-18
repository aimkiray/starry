<%--
  Created by IntelliJ IDEA.
  User: Akari
  Date: 2017/8/29
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(document).ready(function () {
        $("#btn_permission_form").click(function () {
            $.ajax({
                url: "${root}/permission/add",
                type: "post",
                data: $("#permission_form").serialize(),
                dataType: "json",
                success: function (data) {
                    if (data > 0) {
                        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                        /*var select = zTree.getNodeByTId($("#tId").val());

                        if (select.isParent == true) {
                            zTree.reAsyncChildNodes(select, "refresh");
                        } else {
                            zTree.reAsyncChildNodes(select.getParentNode().getParentNode(), "refresh");
                        }*/
                        zTree.reAsyncChildNodes(null, "refresh");
                        $("#manager_right").html("<div class='alert alert-success alert-dismissible' role='alert'>" +
                            "<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>" +
                            "<strong>Lucky!</strong> 添加成功！" +
                            "</div>");
                    } else {
                        alert("添加失败！");
//                        $("#manager_right").html("<div>添加失败</div>");
                    }
//                zTree.expandAll(true);
                },
                error: function () {
                    alert("通信异常");
//                    $("#manager_right").html("<div>通信异常</div>");
                }
            })
        })
    })

</script>

<form method="post" class="form-horizontal" id="permission_form" role="form">
    <div class="form-group">
        <legend>新建权限</legend>
    </div>

    <div class="form-group">
        <label for="permissionName" class="col-sm-2 control-label">权限名称：</label>
        <div class="col-sm-10">
            <input type="text" name="permissionName" id="permissionName" class="form-control" value="">
        </div>
    </div>

    <div class="form-group">
        <label for="url" class="col-sm-2 control-label">权限URL：</label>
        <div class="col-sm-10">
            <input type="text" name="url" id="url" class="form-control" value="">
        </div>
    </div>

    <%--<div class="form-group">
        <label for="parentId" class="col-sm-2 control-label">父权限：</label>
        <div class="col-sm-10">
            <input type="text" name="parentId" id="parentId" class="form-control" value="${requestScope.parentId}">
        </div>
    </div>--%>

    <input type="hidden" id="parentId" name="parentId" value="${requestScope.parentId}">
    <input type="hidden" id="tId" name="tId" value="${requestScope.tId}">

    <div class="form-group">
        <label for="isParent" class="col-sm-2 control-label">父权限：</label>
        <div class="col-sm-10" id="isParent">
            <input type="radio" name="isParent" value="1">是
            <input type="radio" name="isParent" value="0" checked="checked">否
        </div>
    </div>

    <div class="form-group">
        <label for="isMenu" class="col-sm-2 control-label">菜单：</label>
        <div class="col-sm-10" id="isMenu">
            <input type="radio" name="isMenu" value="1">是
            <input type="radio" name="isMenu" value="0" checked="checked">否
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-10 col-sm-offset-2">
            <button type="button" class="btn btn-primary" id="btn_permission_form">Submit</button>
        </div>
    </div>
</form>

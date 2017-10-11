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
    <title>新生</title>
</head>
<script>
    $(document).ready(function () {
        $("#btn_add_user").click(function () {
            $.ajax({
                url: "/user/add",
                cache: false, // 禁用缓存
                contentType : false, // 告诉jQuery不要去设置Content-Type请求头
                processData : false, // 告诉jQuery不要去处理发送的数据
                async: false,
                type: "post",
                dataType: "json",
                data: new FormData($("#addUploadForm")[0]),
                success: function (data) {
                    if (data == 1) {
                        if (typeof userTable === "function") {
                            userTable().Init.ajax.reload()
                        }
                        $(".bootbox-close-button").click();
                    } else {
                        alert("添加失败");
                        $(".bootbox-close-button").click();
                    }
                },
                error: function () {
                    alert("通信失败");
                    $(".bootbox-close-button").click();
                }
            });
        });

        $(".form_datetime").datetimepicker({
            format: "yyyy-mm-dd hh:ii:ss",
            autoclose: true,
            todayBtn: true
        });

//        $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii:ss'});
    });
</script>
<body>

<form id="addUploadForm" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="userName">名称</label>
        <input type="text" class="form-control" id="userName" name="userName" placeholder="君の名は。">
    </div>
    <div class="form-group">
        <label for="nickName">昵称</label>
        <input type="text" class="form-control" id="nickName" name="nickName" placeholder="昵称">
    </div>
    <div class="form-group">
        <label for="userPassword">密码</label>
        <input type="text" class="form-control" id="userPassword" name="userPassword" placeholder="密码">
    </div>
    <div class="form-group">
        <label for="email">邮箱</label>
        <input type="text" class="form-control" id="email" name="email" placeholder="邮箱">
    </div>
    <div class="form-group">
        <label for="userInfo">简介</label>
        <input type="text" class="form-control" id="userInfo" name="userInfo" placeholder="简介">
    </div>
    <div class="form-group">
        <label for="gender">性别</label>
        <div id="gender">
            <label class="radio-inline">
                <input type="radio" name="gender" value="1" >女
            </label>
            <label class="radio-inline">
                <input type="radio" name="gender" value="1" >girl
            </label>
        </div>
    </div>
    <div class="form-group">
        <label for="roleSelect">角色</label>
        <select class="form-control" id="roleSelect" name="userRole">
            <option value="0">请选择</option>
            <c:forEach items="${requestScope.roles}" var="role">
                <option value="${role.roleId}">${role.roleName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="userDate">注册日期</label>
        <input class="form_datetime form-control" id="userDate" name="userDate" type="text" placeholder="注册日期" readonly>
    </div>
    <div class="form-group">
        <label for="uploadPic">File input</label>
        <input type="file" id="uploadPic" name="uploadPic">
        <p class="help-block">头像上传</p>
    </div>

    <button type="button" id="btn_add_user" class="btn btn-default">提交</button>
</form>
</body>
</html>

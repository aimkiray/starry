<%--
  Created by IntelliJ IDEA.
  User: nekuata
  Date: 2017/7/21
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>进化</title>
</head>
<script>
    $(document).ready(function () {
        $("#btn_update_user").click(function () {
            $.ajax({
                url: "/author/doupdate.do",
                cache: false, //禁用缓存
                contentType : false,// 告诉jQuery不要去设置Content-Type请求头
                processData : false,// 告诉jQuery不要去处理发送的数据
                async: false,
                type: "post",
                data: new FormData($("#uploadForm")[0]),
                success: function (data) {
                    if (data == "true") {
                        authorTable().Init.ajax.reload();
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
        });

        $(".form_datetime").datetimepicker({
            format: "yyyy-mm-dd hh:ii:ss",
            autoclose: true,
            todayBtn: true
        });

        $(document).click(function(e){
            var _con = $(".modal-content");   // 设置目标区域
            if(!_con.is(e.target) && _con.has(e.target).length === 0){ // Mark 1
                $(".bootbox-close-button").click();
            }
        });
    });
</script>
<body>
<c:set var="user" value="${requestScope.user}" />
<fmt:formatDate value="${user.userDate}" pattern="yyyy-MM-dd HH:mm:ss" var="userDate"/>
<form id="uploadForm" method="post" enctype="multipart/form-data">
    <input type="hidden" name="userId" value="${user.userId}">
    <input type="hidden" name="headshot" value="${user.headshot}">
    <div class="form-group">
        <label for="userName">名称</label>
        <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}" placeholder="君の名は。">
    </div>
    <div class="form-group">
        <label for="nickName">昵称</label>
        <input type="text" class="form-control" id="nickName" name="nickName" value="${user.nickName}" placeholder="昵称">
    </div>
    <div class="form-group">
        <label for="userPassword">密码</label>
        <input type="text" class="form-control" id="userPassword" name="userPassword" value="${user.userPassword}" placeholder="密码">
    </div>
    <div class="form-group">
        <label for="userInfo">简介</label>
        <input type="text" class="form-control" id="userInfo" name="userInfo" value="${user.userInfo}" placeholder="简介">
    </div>
    <div class="form-group">
        <label for="userDate">注册日期</label>
        <input class="form_datetime form-control" id="userDate" name="userDate" type="text" value="${userDate}" placeholder="注册日期" readonly>
    </div>
    <div class="form-group">
        <label for="uploadPic">File input</label>
        <input type="file" id="uploadPic" name="uploadPic">
        <p class="help-block">头像上传</p>
    </div>

    <button type="button" id="btn_update_user" class="btn btn-default">提交</button>
</form>
</body>
</html>

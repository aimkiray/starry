$(document).ready(function () {

    // 选中标签添加到表单中（隐藏域形式）
    $("#selectTag").change(function () {
        // 用户选中的标签
        var newTag = $("#selectTag").find("option:selected").text();
        // 重置select
        var checkValue = $("#selectTag").val();
        $("#selectTag").val(0);
        $("#formTag").html('<input type="hidden" name="tagId" id="tagId" value="'+checkValue+'">');
        // 显示要处理的标签
        $("#tagArea").val(newTag);
    });

    $("#addTag").click(function () {
        $.ajax({
            url: "/tag/add",
            type: "post",
            dataType: "json",
            data: {
                tagName: $("#inputTag").val()
            },
            success: function (data) {
                // 返回新标签的Id
                if (data > 0) {
                    // 把新Id加入全家桶...form
                    $("#formTag").html('<input type="hidden" id="tagId" name="tagId" value="'+data+'">');
                    // 加入肯德基超值豪华午餐...select
                    $("#selectTag").append('<option value="'+data+'">'+$("#inputTag").val()+'</option>');
                    // 清空input
                    $("#inputTag").val('')
                    alert("添加成功！")
                } else {
                    alert("标签已存在")
                }
            },
            error: function () {
                alert("执行失败！⊙﹏⊙")
            }
        })
    });

    $("#updateTag").click(function () {
        $.ajax({
            url: "/tag/update",
            type: "post",
            dataType: "json",
            data: {
                tagId: $("#tagId").val(),
                tagName: $("#inputTag").val()
            },
            success: function (data) {
                if (data > 0) {
                    alert("修改成功！")
                } else {
                    alert("修改失败，请检查标签是否为空")
                }
            },
            error: function () {
                alert("执行失败！⊙﹏⊙")
            }
        })
    });

    $("#delTag").click(function () {
        $.ajax({
            url: "/tag/del",
            type: "post",
            dataType: "json",
            data: {
                tagId: $("#tagId").val()
            },
            success: function (data) {
                if (data > 0) {
                    alert("删除成功！")
                } else {
                    alert("删除失败，请检查标签是否被使用")
                }
            },
            error: function () {
                alert("执行失败！⊙﹏⊙")
            }
        })
    });

});
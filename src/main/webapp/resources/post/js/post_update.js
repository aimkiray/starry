$(document).ready(function () {
    /*// TODO 动态更改文章标签大小
    var taglength = $(".tagArea").val().length;
    // alert(taglength);
    $(".tagArea").css('width', taglength*30 + 'px');*/


    // 选中标签添加到表单中（隐藏域形式）
    $("#selectTag").change(function () {
        // 用户选中的标签
        var newTag = $("#selectTag").find("option:selected").text();
        // 已有标签
        var oldTag = $("#tagArea").val();
        // 标签没被选中
        if (oldTag.indexOf(newTag) == -1) {
            var checkValue = $("#selectTag").val();
            $("#formTag").append('<input type="hidden" name="tagId" value="'+checkValue+'">')
            $("#tagArea").val(oldTag+" "+newTag);
        }
        // 清空选中
        $("#selectTag").val(0);
    });

    // 清空标签
    $("#cleanTag").click(function () {
        $("#formTag").html('');
        $("#tagArea").val('');
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
                    // 把新Id加入全家桶
                    $("#formTag").append('<input type="hidden" name="tagId" value="'+data+'">');
                    // 更新显示
                    $("#tagArea").val($("#tagArea").val()+" "+$("#inputTag").val());
                    // 加入肯德基超值豪华午餐...select
                    $("#selectTag").append('<option value="'+data+'">'+$("#inputTag").val()+'</option>');
                    // 清空input
                    $("#inputTag").val('')
                } else {
                    alert("标签已存在→")
                }
            },
            error: function () {
                alert("执行失败！⊙﹏⊙")
            }
        })
    });

    $("#btn-publish").click(function () {
        $("#postStatus").val("publish");
        updatePost();
    });

    $("#btn-save").click(function () {
        $("#postStatus").val("save");
        updatePost();
    });

    function updatePost() {
        $.ajax({
            url: "/post/update",
            type: "post",
            dataType: "json",
            data: $("#postUploadForm").serialize(),
            success: function (data) {
                if (data > 0) {
                    window.open("/post/list/page","_self")
                } else {
                    alert("发布失败⊙﹏⊙")
                }
            },
            error: function () {
                alert("执行失败，请检查标签是否输入⊙﹏⊙")
            }
        })
    }

})
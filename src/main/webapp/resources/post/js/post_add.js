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
        var checkValue = $("#selectTag").val();
        $("#selectTag").val(0);
        $("#formTag").append('<input type="hidden" name="tagId" value="'+checkValue+'">')
        $("#tagArea").val(oldTag+" "+newTag);
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
        addPost();
    });

    $("#btn-save").click(function () {
        $("#postStatus").val("save");
        addPost();
    });

    function addPost() {
        $.ajax({
            url: "/post/add",
            type: "post",
            dataType: "json",
            data: $("#postUploadForm").serialize(),
            success: function (data) {
                console.log(0);
                if (data > 0) {
                    console.log(1);
                    window.open("/post/list/page","_self")
                } else {
                    console.log(2);
                    alert("发布失败⊙﹏⊙")
                }
            },
            error: function () {
                console.log(3);
                alert("执行失败⊙﹏⊙")
            }
        })
    }

})
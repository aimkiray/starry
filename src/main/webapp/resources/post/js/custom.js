$(document).ready(function () {

    // 初始化文章
    markdownHtml();
});

// markdown2html
function markdownHtml() {
    // 获取当前页面所有文章的Id
    $("input[name='postId']").each(function () {
        // 获取当前Id
        var postId = $(this).val();
        // 获取markdown格式的文章
        var rawPost = $("#rawPost"+postId).text();
        // 创建showdown实例
        var converter = new showdown.Converter();
        // 开始转换
        var htmlPost = converter.makeHtml(rawPost);
        // 展示文章
        $("#htmlPost"+postId).html(htmlPost);
    });
    /*// 获取markdown格式的文章
    var rawPost = $("#rawPost").val();
    // 创建showdown实例
    var converter = new showdown.Converter();
    // 开始转换
    var htmlPost = converter.makeHtml(rawPost);
    // 展示文章
    console.log(htmlPost);
    $("#htmlPost").html(htmlPost);*/
}
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
        // 调用markdown-it
        var md = window.markdownit({
            highlight: function (str, lang) {
                if (lang && hljs.getLanguage(lang)) {
                    try {
                        return '<pre class="hljs"><code>' +
                            hljs.highlight(lang, str, true).value +
                            '</code></pre>';
                    } catch (__) {}
                }

                return '<pre class="hljs"><code>' + md.utils.escapeHtml(str) + '</code></pre>';
            }
        });
        // 开始转换
        var htmlPost = md.render(rawPost);
        // 展示文章
        $("#htmlPost"+postId).html(htmlPost);
    });
}
$(document).ready(function () {
    /*// TODO 动态更改文章标签大小
    var taglength = $(".tagArea").val().length;
    // alert(taglength);
    $(".tagArea").css('width', taglength*30 + 'px');*/


    $("#selectTag").change(function () {
        var checkText = $("#selectTag").find("option:selected").text();
        var checkValue = $("#selectTag").val();
        $("#selectTag").val(0);
        $("#formTag").append('<span id="tagSpan0">' +
            '            <input class="form-control tagArea" type="text" value="'+checkText+'" readonly>' +
            '            <input type="hidden" name="tagId" value="'+checkValue+'">' +
            '        </span>')
    })

})
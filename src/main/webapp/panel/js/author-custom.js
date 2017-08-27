/**
 * Created by nekuata on 2017/7/20.
 */

$(document).ready(function () {
    // alert($("#typeId").val());
    // 初始化Table
    // authorTable;

    authorTable();
    // 初始化Button的点击事件
    buttonInit();

    // 丢掉datatables报错信息（官方方案之一）
    $.fn.dataTable.ext.errMode = 'throw';

});

//提示信息
var lang = {
    "sProcessing": "处理中...",
    "sLengthMenu": "每页 _MENU_ 项",
    "sZeroRecords": "没有匹配结果",
    "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
    "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
    "sInfoPostFix": "",
    "sSearch": "搜索:",
    "sUrl": "",
    "sEmptyTable": "表中数据为空",
    "sLoadingRecords": "载入中...",
    "sInfoThousands": ",",
    "oPaginate": {
        "sFirst": "首页",
        "sPrevious": "上页",
        "sNext": "下页",
        "sLast": "末页",
        "sJump": "跳转"
    },
    "oAria": {
        "sSortAscending": ": 以升序排列此列",
        "sSortDescending": ": 以降序排列此列"
    }
};

//初始化表格
var authorTable = function () {
    var tableParam = {};
    tableParam.Init = $("#author_list").dataTable({
        // destroy: true, //创建表格前先删除旧表格
        dom: '<"top"i>rt<"bottom"flp><"clear">',
        lengthMenu: [5, 10, 25, 50],
        language: lang,  //提示信息
        autoWidth: false,  //禁用自动调整列宽
        stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
        processing: true,  //隐藏加载提示,自行处理
        serverSide: true,  //启用服务器端分页
        searching: false,  //禁用原生搜索
        orderMulti: false,  //启用多列排序
        order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
        renderer: "bootstrap",  //渲染样式：Bootstrap和jquery-ui
        pagingType: "simple_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
        columnDefs: [{
            "targets": 'nosort',  //列的样式名
            "orderable": false    //包含上样式名‘nosort’的禁止排序
        }],
        ajax: {
            url: '/author/search.do',
            type: 'POST',
            dataType: "json",
            data: {
                authorName : $("#authorNameSearch").val(),
                nickName : $("#nickNameSearch").val()
            }
        },
        //列表表头字段
        columns: [
            {data : "name", "orderable": false, "width": "2%", "render": function(data,type,row,meta){ return '<input type="checkbox" name="'+data+'">'; } },
            {data : "headshot", "orderable": false, "width": "12px", "render": function(data,type,row,meta){ return '<img style="width: 50px" src="/headimg/'+data+'"/>'; } },
            {data : "authorId"},
            {data : "authorName"},
            {data : "nickName"},
            {data : "authorInfo"},
            {data : "authorDate"},
            {
                data : "authorId",
                render: function (data, type, row) {
                    return '<button class="btn btn-info btn-sm" onclick="updateAuthor('+data+')"><i class="fa fa-pencil"></i>修改</button>' +
                        '&nbsp;&nbsp;' +
                        '<button class="btn btn-danger btn-sm" onclick="delAuthor('+data+')"><i class="fa fa-trash-o"></i>删除</button>';
                }
            },
        ]
    }).api();
//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象

    return tableParam;
}

function updateAuthor(authorId) {
    $.ajax({
        url: "/author/update.do?authorId=" + authorId,
        type: "post",
        dataType: "text",
        /*data: {
            authorName : $("#authorNameSearch").val(),
            nickName : $("#nickNameSearch").val()
        },*/
        success: function (data) {
            bootbox.dialog({
                message: data,
                title: "修改信息"
            })
        },
        error: function () {
            alert("通信失败");
        }
    });
}

function delAuthor(authorId) {
    bootbox.confirm({
        message: "确认删除？",
        buttons: {
            confirm: {
                label: '确认',
                className: 'btn-success'
            },
            cancel: {
                label: '取消',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/author/delete.do?authorId=" + authorId,
                    type: "post",
                    dataType: "text",
                    success: function () {
                        authorTable().Init.ajax.reload();
                        $(".bootbox-close-button").click();
                    },
                    error: function () {
                        alert("删除失败");
                        $(".bootbox-close-button").click();
                    }
                });
            } else {
                $(".bootbox-close-button").click();
            }
        }
    });
}


function buttonInit() {

    // 初始化页面上面的按钮事件

    $(document).click(function (e) {
        var _con = $(".modal-content");   // 设置目标区域
        if (!_con.is(e.target) && _con.has(e.target).length === 0) { // Mark 1
            $(".bootbox-close-button").click();
        }
    });

    $("#btn_add").click(function () {
        $.ajax({
            url: "/author/add.do",
            type: "post",
            dataType: "text",
            success: function (data) {
                bootbox.dialog({
                    message: data,
                    title: "添加产品"
                })
            },
            error: function () {
                alert("通信失败");
            }
        });
    });

    $("#btn_query").click(function () {
        // alert(1);
        /*var param = {};
        param.authorName = $("#authorNameSearch").val();
        param.nickName = $("#nickNameSearch").val();
        param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
        // param.start = data.start;//开始的记录序号
        param.pageNumber = (data.start / data.length) + 1;//当前页码
        authorTable.settings()[0].ajax.data = param;*/
        // $("#author_list").ajax.reload();
        // authorTable.ajax.reload();
        authorTable().Init.ajax.draw(false);
    });
}
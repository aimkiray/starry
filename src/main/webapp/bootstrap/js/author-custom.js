/**
 * Created by nekuata on 2017/7/20.
 */

$(document).ready(function () {
    // alert($("#typeId").val());
    // 初始化Table
    authorTableInit();
    buttonInit();

});

//初始化Table
function authorTableInit() {
    $('#tb_author').empty();
    $('#tb_author').bootstrapTable('destroy').bootstrapTable({
        url: '/author/search.do',  //servlet的url地址,调用ajax获取json数据。
        method: 'post',                      //请求方式
        dataType: 'json',                   //返回json
        // contentType:
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        // sortOrder: "asc",                   //排序方式
        queryParams: queryParams,//传递参数（*）
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],      //可供选择的每页的行数（*）
        // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        // strictSearch: true,
        showColumns: true,                  //是否显示所有的列
        // showRefresh: true,                  //是否显示刷新按钮
        // minimumCountColumns: 2,             //最少允许的列数
        // clickToSelect: true,                //是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "authorId",              //每一行的唯一标识，一般为主键列
        // showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                  //是否显示父子表

        columns: [{
            field: 'authorId',
            checkbox: false,
            align: 'center',
            valign: 'middle',
        }, {
            title: '用户名',
            field: 'authorName',
            align: 'center',
            valign: 'middle',
            editable: {
                type: 'text',
                title: '修改用户名',
                placement: 'right',
                validate: function (value) {
                    if (!value) return '不能为空';
                }
            }
        }, {
            title: '昵称',
            field: 'nickName',
            align: 'center',
            valign: 'middle',
            editable: {
                type: 'text',
                title: '修改昵称',
                placement: 'right',
                validate: function (value) {
                    if (!value) return '不能为空';
                }
            }
        }, {
            title: '注册时间',
            field: 'authorDate',
            align: 'center',
            valign: 'middle',
            editable: {
                type: 'text',
                title: '注册时间',
                placement: 'right',
            }
        }, {
            title: '作者简介',
            field: 'authorInfo',
            align: 'center',
            valign: 'middle'
        }, {
            title: '操作',
            field: 'authorId',
            align: 'center',
            valign: 'middle',
            formatter: operateFormatter //自定义方法，添加操作按钮
        }],
    });
};

//需要给服务器端传的参数
function queryParams(params) {
    var param = {
        //键名与servlet要相同
        pageSize: params.limit,   //页面大小
        pageNumber: params.offset,  //页码
        authorName: $("#authorNameSearch").val(),
        nickName: $("#nickNameSearch").val()
    };
    return param;
};

function operateFormatter(value, row, index) {//赋予的参数
    return [
        '<button class="btn btn-info btn-sm rightSize detailBtn" type="button" value="' + value + '" onclick="updateAuthor(this.value)" ><i class="fa fa-paste"></i>修改</button>',
        '<button class="btn btn-danger btn-sm rightSize packageBtn" type="button" value="' + value + '" onclick="delAuthor(this.value)"><i class="fa fa-envelope"></i>删除</button>'
    ].join(' ');
}


function updateAuthor(value) {
    $.ajax({
        url: "/authorservlet.do?operate=getUpdateAuthorJsp&authorId=" + arguments[0],
        type: "post",
        dataType: "text",
        success: function (data) {
            bootbox.dialog({
                message: data,
                title: "修改产品"
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
                    url: "/authorservlet.do?operate=delauthor&authorId=" + authorId,
                    type: "post",
                    dataType: "text",
                    success: function () {
                        $(".bootbox-close-button").click();
                    },
                    error: function () {
                        alert("删除失败");
                        // $(".bootbox-close-button").click();
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
            url: "/authorservlet.do?operate=getaddauthorjsp",
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
        $("#tb_author").bootstrapTable('refresh');
    });

    /*弹出修改作者
    $("#btn_update_author").click(function () {
        alert(1);
        $.ajax({
            url: "/authorservlet.do?operate=getupdateauthorjsp",
            type: "post",
            dataType: "text",
            success: function (data) {
                bootbox.dialog({
                    message: data,
                    title: "修改产品"
                })
            },
            error: function () {
                alert("通信失败");
            }
        });
    });*/

    /*$("#btn_edit").click(function () {
       var arrselections = $("#tb_author").bootstrapTable('getSelections');
       if (arrselections.length > 1) {
           toastr.warning('只能选择一行进行编辑');

           return;
       }
       if (arrselections.length <= 0) {
           toastr.warning('请选择有效数据');

           return;
       }
       $("#myModalLabel").text("编辑");
       $("#txt_departmentname").val(arrselections[0].DEPARTMENT_NAME);
       $("#txt_parentdepartment").val(arrselections[0].PARENT_ID);
       $("#txt_departmentlevel").val(arrselections[0].DEPARTMENT_LEVEL);
       $("#txt_statu").val(arrselections[0].STATUS);

       postdata.DEPARTMENT_ID = arrselections[0].DEPARTMENT_ID;
       $('#myModal').modal();
    });*/

    /*$("#btn_delete").click(function () {
       var arrselections = $("#tb_author").bootstrapTable('getSelections');
       if (arrselections.length <= 0) {
           toastr.warning('请选择有效数据');
           return;
       }

       Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
           if (!e) {
               return;
           }
           $.ajax({
               type: "post",
               url: "/Home/Delete",
               data: { "": JSON.stringify(arrselections) },
               success: function (data, status) {
                   if (status == "success") {
                       toastr.success('提交数据成功');
                       $("#tb_author").bootstrapTable('refresh');
                   }
               },
               error: function () {
                   toastr.error('Error');
               },
               complete: function () {

               }

           });
       });
    });*/

    /*$("#btn_submit").click(function () {
       postdata.DEPARTMENT_NAME = $("#txt_departmentname").val();
       postdata.PARENT_ID = $("#txt_parentdepartment").val();
       postdata.DEPARTMENT_LEVEL = $("#txt_departmentlevel").val();
       postdata.STATUS = $("#txt_statu").val();
       $.ajax({
           type: "post",
           url: "/Home/GetEdit",
           data: { "": JSON.stringify(postdata) },
           success: function (data, status) {
               if (status == "success") {
                   toastr.success('提交数据成功');
                   $("#tb_author").bootstrapTable('refresh');
               }
           },
           error: function () {
               toastr.error('Error');
           },
           complete: function () {

           }

       });
    });*/

};
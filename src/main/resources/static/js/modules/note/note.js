
var noteContext = '';
layui.use(['form','table','util'], function(){
    var form = layui.form
        table = layui.table,
        util = layui.util;

    form.on('submit(addNote)', function(data){
        data.field.content = noteContext;
        console.log(JSON.stringify(data.field));
        $.ajax({
            url: PATH + 'note/addNote',
            type: 'put',
            dataType: 'json',
            data: {
                'noteData': JSON.stringify(data.field),
                '_csrf': $("meta[name = '_csrf']").attr("content"),
                '_csrf_header': $("meta[name = '_csrf_header']").attr("content"),
                '_': new Date().getTime()
            },
            success: function (res) {
                if(res.code == 0){
                    layer.msg(res.message);
                }
            },error(res){
                layer.msg(res.message);
            }
        });
        return false;
    });
    tableRender(table, form);

    $('#noteText').keyup(function(){
        showDownRun();
    });

    function showDownRun() {
        var text = document.getElementById('noteText').value,
            target = document.getElementById('mdText'),
            converter = new showdown.Converter(),
            html = converter.makeHtml(text);
        noteContext = html + '';
        target.innerHTML = html;
    }

    /*============================[ 笔记分类 ]============================*/
    function tableRender(table, form){
        table.render({
            id: 'noteCateTable',
            elem: '#noteCateTable',
            url: PATH + "note/getNoteCategory",
            toolbar: '#noteCateTableTopbar',
            //width: 1640,
            height: 'full-203',
            title: '管理员表',
            page: true,
            text: {
                none: '暂无相关数据'
            },
            cols: [[
                {type: 'checkbox'},
                {field: 'index', title: '序号', width:90, type:'numbers'},
                {field: 'cateId', title: 'ID', sort: true, hide: true},
                {field: 'cateCode', title: '分类编码', width:275},
                {field: 'cateName', title: '分类名称', width:275},
                {field: 'cateParentId', title: '上级分类', hide: true},
                {field: 'cateSort', title: '排序', width: 180, sort: true, align: 'center', unresize: true},
                {field: 'createTime', title: '创建时间', width: 275, sort: true, align: 'center', unresize: true},
                {field: 'updateTime', title: '更新时间', width: 275, sort: true, align: 'center', unresize: true},
                {field: 'operation', title: '操作', width: 164, toolbar: '#noteCateTableOperbar', align: 'center', unresize: true}
            ]]
            ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.data.count, //解析数据长度
                    "data": res.data.data //解析数据列表
                };
            }
        });

        table.on('tool(noteCateTable)', function (d) {
            switch (d.event) {
                case 'edit': editCate(d.data, table, form); break;
                case 'del': delCate(d.data, table); break;
            }
        });

        table.on('toolbar(noteCateTable)', function (ope) {
            switch (ope.event) {
                case 'addCate': addCate(table, form); break;
                case 'batchesDel': batchesDelCate(table.checkStatus(ope.config.id), table); break;
            }
        });
    };

    function addCate(table){
        var add = '<i class="layui-icon">&#xe605;</i>提交',
            close = '<i class="layui-icon">&#x1006;</i>返回';

        layer.open({
            type: 2,
            title: '添加笔记分类',
            area: ['796px', '370px'],
            offset: 'auto',
            btnAlign: 'r',
            fixed: false,
            maxmin: true,
            shadeClose: true,
            content: PATH +'note/addCate',
            btn: [add, close],
            yes: function(index, layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                var cateAddForm = iframeWin.document.getElementById('cateAddForm');
                var dataArray = $(cateAddForm).serializeArray(), datas = {};
                $.each(dataArray, function(){
                    datas[this.name] = this.value;
                });
                $.ajax({
                    url: PATH + 'note/addCate',
                    type: 'PUT',
                    dataType: 'JSON',
                    data: {
                        'formData': JSON.stringify(datas),
                        '_csrf': $(iframeWin.document.getElementsByName("_csrf")).attr("content"),
                        '_csrf_header': $(iframeWin.document.getElementsByName("_csrf_header")).attr("content"),
                        '_': new Date().getTime()
                    },
                    success: function(res){
                        if(res.code == 0){
                            layer.msg(res.message);
                            table.reload('noteCateTable', {
                                url: PATH + 'note/getNoteCategory'
                                ,page: {curr: 1}
                            });
                        }else{
                            layer.msg(res.message);
                        }
                    },
                    error: function(res){
                        layer.msg(res.message);
                    }
                });
                return false;
            },
            btn2: function(index, layero){
            }
        });
    };

    function editCate(data, table){
        var add = '<i class="layui-icon">&#xe605;</i>更新',
            close = '<i class="layui-icon">&#x1006;</i>返回';

        layer.open({
            type: 2,
            title: '分类更新',
            area: ['796px', '370px'],
            offset: 'auto',
            btnAlign: 'r',
            fixed: false,
            maxmin: true,
            shadeClose: true,
            content: PATH +'note/editCate/' + data.cateId,
            btn: [add, close],
            yes: function(index, layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                var cateAddForm = iframeWin.document.getElementById('cateEditForm');
                var dataArray = $(cateAddForm).serializeArray(), datas = {};
                console.log(dataArray);
                $.each(dataArray, function(){
                    datas[this.name] = this.value;
                });
                $.ajax({
                    url: PATH + 'note/editCate',
                    type: 'POST',
                    dataType: 'JSON',
                    data: {
                        'formData': JSON.stringify(datas),
                        '_csrf': $(iframeWin.document.getElementsByName("_csrf")).attr("content"),
                        '_csrf_header': $(iframeWin.document.getElementsByName("_csrf_header")).attr("content"),
                        '_': new Date().getTime()
                    },
                    success: function(res){
                        if(res.code == 0){
                            layer.msg(res.message);
                            table.reload('noteCateTable', {
                                url: PATH + 'note/getNoteCategory'
                                ,page: {curr: 1}
                            });
                        }else{
                            layer.msg(res.message);
                        }
                    },
                    error: function(res){
                        layer.msg(res.message);
                    }
                });
                return false;
            },
            btn2: function(index, layero){
            }
        });
        CATE_PID = data.cateParentId;
    };

    function delCate(data, table){
        layer.msg("delCate = " + data.cateCode);
        $.ajax({
            url: PATH + 'note/delCate/' + data.cateId,
            type: 'DELETE',
            dataType: 'json',
            data: {
                '_csrf': $("meta[name = '_csrf']").attr("content"),
                '_csrf_header': $("meta[name = '_csrf_header']").attr("content"),
                '_': new Date().getTime()
            },
            success: function(res){
                if(res.code == 0){
                    layer.msg(res.message);
                    table.reload('noteCateTable', {
                        url: PATH + 'note/getNoteCategory'
                        ,page: {curr: 1}
                    });
                }else{
                    layer.msg(res.message);
                }
            },
            error: function(res){
                layer.msg(res.message);
            }
        });
    };

    function batchesDelCate(data, table) {

        console.log(data.data);
        if(data.data.length == 0){
            layer.msg('未选中任何数据，请勾选数据！');
            return false;
        }
        var ids = [];
        for (var i = 0; i < data.data.length; i++){
            console.log(data.data[i].cateId);
            ids[i] = data.data[i].cateId;
        }
        console.log(ids);
        if(ids.length == 0){
            layer.msg('数据转换出错，请联系管理员！');
            return false;
        }

        $.ajax({
            url: PATH + 'note/batchesDelCate',
            type: 'DELETE',
            dataType: 'json',
            data: {
                'ids': JSON.stringify(ids),
                '_csrf': $("meta[name = '_csrf']").attr("content"),
                '_csrf_header': $("meta[name = '_csrf_header']").attr("content"),
                '_': new Date().getTime()
            },
            success: function(res){
                if(res.code == 0){
                    layer.msg(res.message);
                    table.reload('noteCateTable', {
                        url: PATH + "note/getNoteCategory"
                        ,page: {curr: 1}
                    });
                }else{
                    layer.msg(res.message);
                }
            },
            error: function(res){
                layer.msg(res.message);
            }
        });
    };
});

function rendSelect(form){
    $.get({
        url: PATH + 'note/getNoteCategory',
        dataType: 'json',
        success: function (res) {
            if(res.code == 0){
                var OPTION = '<option value="">顶级分类</option>';
                res.data.data.forEach(function(item, index){
                    OPTION = OPTION + '<option value="' + item.cateId + '">' + item.cateName + '</option>';
                });
                $("#cateParentId").html(OPTION);
                form.render('select');
            }
        }
    });
}

function xmSelectRun(){
    var cates = [];
    $.get({
        url: PATH + 'note/getNoteCategory',
        dataType: 'json',
        success: function (res) {
            if(res.code == 0){
                res.data.data.forEach(function(item, index){
                    //  组装数据
                    var cateItem = {name: item.cateName,value: item.cateCode};
                    cates[index] = cateItem;
                });

                //  渲染下拉框
                xmSelect.render({
                    el: '#noteCate',
                    name: 'noteCate',
                    language: 'zn',
                    tips: '请选择分类',
                    empty: '暂无分类，请先添加笔记分类',
                    filterable: true,
                    data: cates
                });
            }else{
                layer.msg(res.message);
            }
        }
    });
}

function searchCates(){
    table.reload('noteCateTable', {
        url: PATH + "note/search",
        page: {curr: 1},
        where:{
            'cateCode': $("#cateCode").val()
        }
    });
    return false;
};
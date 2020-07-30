
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
    tableRender(table);
});

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

function xmSelectRun(){
    var cates = [];
    $.get({
        url: PATH + 'note/getNoteCategory',
        dataType: 'json',
        success: function (res) {
            if(res.code == 0){
                res.data.data.forEach(function(item, index){
                    var cateItem = {name: item.cateName,value: item.cateCode};
                    cates[index] = cateItem;
                });
                var $noteCate = xmSelect.render({
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

/*============================[ 笔记分类表 ]============================*/
function tableRender(table){
    table.render({
        id: 'noteCateTable',
        elem: '#noteCateTable',
        url: PATH + "note/getNoteCategory",
        //toolbar: '#adminListTableTopbar',
        height: 'full-203',
        title: '管理员表',
        page: true,
        text: {
            none: '暂无相关数据'
        },
        cols: [[
            {type: 'checkbox'},
            {field: 'index', title: '序号', width:80, type:'numbers'},
            {field: 'cateId', title: 'ID', sort: true, hide: true},
            {field: 'cateCode', title: '分类编码', width:160},
            {field: 'cateName', title: '分类名称', width:160},
            {field: 'cateParentId', title: '上级分类', width:100, sort: true},
            {field: 'cateSort', title: '排序', width: 130, sort: true},
            {field: 'createTime', title: '创建时间', width: 250, sort: true/*, templet: '#timeTPL'*/},
            {field: 'updateTime', title: '更新时间', width: 250, sort: true/*, templet: '#timeTPL'*/},
            {field: 'operation', title: '操作', width: 269, toolbar: '#noteCateTableOperbar'}
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
};
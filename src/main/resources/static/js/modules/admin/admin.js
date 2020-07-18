function tableRender(table, path)
{
    table.render({
        id: 'adminListTable',
        elem: '#adminListTable',
        url: path+"admin/getAllAdmin",
        toolbar: '#adminListTableTopbar',
        height: 'full-203',
        title: '管理员表',
        page: true,
        text: {
            none: '暂无相关数据'
        },
        cols: [[
            {type: 'checkbox'},
            {field: 'index', title: '序号', width:80, type:'numbers'},
            {field: 'id', title: 'ID', sort: true, hide: true},
            {field: 'loginName', title: '登录名', width:160},
            {field: 'adminName', title: '管理员名称', width:160},
            {field: 'sort', title: '排序', width:100, sort: true},
            {field: 'status', title: '状态', width: 130, sort: true, templet: '#statusTPL'},
            {field: 'creatorId', title: '创建者ID',hide: true},
            {field: 'creator', title: '创建者', width: 150, templet: '#creatorTPL'},
            {field: 'createTime', title: '创建时间', width: 250, sort: true},
            {field: 'updateTime', title: '更新时间', width: 250, sort: true},
            {field: 'operation', title: '操作', width: 269, toolbar: '#adminListTableOperbar'}
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

    table.on('tool(adminListTable)', function (d) {
        var data = d.data;
        switch (d.event) {
            case 'enable': enableAdmin(data, path, table); break;
            case 'disable': disableAdmin(data, path, table); break;
            case 'edit': editAdmin(data, path, table); break;
            case 'del': delAdmin(data, path, table); break;
        }
    });

    table.on('toolbar(adminListTable)', function (ope) {

        switch (ope.event) {
            case 'addAdmin': addAdmin(path, table); break;
            case 'batchesDel':
                var checkStatus = table.checkStatus(ope.config.id);
                var data = checkStatus.data;
                batchesDel(data, path, table);
                break;
        }
    });
}

function loadAdminRole(path)
{
    $.get({
        url: path+'adminRole/getRoleList',
        dataType: 'json',
        success: function(res){
            var options="<option>全部管理员角色</option>";
            $.each(res.data.data, function(i, item){
                var option = '<option value="'+item.roleCode+'">'+item.roleName+'</option>';
                options = options + option;
            });
            $("select#role").html(options);
        }
    })
}

function loadData(form, path)
{
    $.get({
        url: path+'admin/getAdmin/'+$('input[name="id"]').val(),
        dataType: 'json',
        success: function(res){
            if(res.code == 0){
                form.val('adminDetailsForm',{
                    'loginName': res.data.loginName,
                    'adminName': res.data.adminName,
                    'role': res.data.role,
                    'roleName': res.data.roleName,
                    'status': res.data.status,
                    'adminEmail': res.data.adminEmail,
                    'sort': res.data.sort,
                    'loginIp': res.data.loginIp,
                    'creatorId': res.data.creatorId,
                    'creator': res.data.creator,
                    'createTime': res.data.createTime,
                    'remark': res.data.remark
                });
                $("input[name='status']").each(function(){
                   if($(this).val() == res.data.status){
                       $(this).attr("checked","checked");
                   }
                });
            }else{
                layer.msg(res.message);
            }
        },
        error: function(res){
            layer.msg(res.message);
        }
    });
}

function addAdmin(path, table)
{
    var aPath = path, atable = table;
    var edit = '<i class="layui-icon">&#xe605;</i>提交',
        waive = '<i class="layui-icon">&#x1006;</i>返回';

    layer.open({
        type: 2,
        title: '添加管理员账号',
        area: ['1080px', '780px'],
        offset: 'auto',
        btnAlign: 'r',
        fixed: false,
        maxmin: true,
        shadeClose: true,
        content: path+'admin/view/add',
        btn: [edit, waive],
        yes: function(index, layero){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            var addAdminForm = iframeWin.document.getElementById('addAdminForm');
            var dataArray = $(addAdminForm).serializeArray(), datas = {};
            $.each(dataArray, function(){
                datas[this.name] = this.value;
            });
            console.log(datas);

            $.ajax({
                url: aPath + 'admin/add',
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
                        atable.reload('adminListTable', {
                            url: path+"admin/getAllAdmin"
                            ,page: {curr: 1}
                        });
                    }else{
                        layer.msg(res.message);

                    }
                },
                error: function(res){
                    layer.msg(res.message);
                }
            })
            return false;
        },
        btn2: function(index, layero){
        }
    });
};

function batchesDel(data, path, table)
{
    var aData = data, aPath = path, atable = table;

    if(aData.length == 0){
        layer.msg('未选中任何帐号，请勾选要删除的帐号！');
        return false;
    }
    var ids = [];
    for (var i = 0; i < aData.length; i++){
        ids[i] = aData[i].id;
    }
    if(ids.length == 0){
        layer.msg('数据转换出错，请联系管理员！');
        return false;
    }

    layer.prompt({
        formType: 1,
        title: '请输入登录密码',
        maxlength: 20
    },function(value, index, layero){

        var uri = aPath+'admin/batchesDel';
        $.ajax({
            url: uri,
            type: 'DELETE',
            dataType: 'json',
            data: {
                'pass': value,
                'ids': JSON.stringify(ids),
                '_csrf': $("meta[name = '_csrf']").attr("content"),
                '_csrf_header': $("meta[name = '_csrf_header']").attr("content"),
                '_': new Date().getTime()
            },
            success: function(res){
                if(res.code == 0){
                    layer.close(index);
                    layer.msg(res.message);
                    atable.reload('adminListTable', {
                        url: path+"admin/getAllAdmin"
                        ,page: {curr: 1}
                    });
                }else{
                    layer.msg(res.message);
                }
            },
            error: function(res){
                layer.close(index);
                layer.msg(res.message);
            }
        });
    });
}

function enableAdmin(data, path, table)
{
    if(data.status == 0)
    {
        layer.msg("管理员"+data.loginName+"已启用，已取消此操作！");
    }else{
        layer.confirm('是否启用管理员 '+data.loginName,{
            title: '启用管理员'
            ,btn: ['启用','返回']
        }, function(){
            $.post({
                url: path+'admin/enable'
                ,dataType: 'JSON'
                ,data: {
                    'id': data.id,
                    '_csrf': $("meta[name = '_csrf']").attr("content"),
                    '_csrf_header': $("meta[name = '_csrf_header']").attr("content"),
                    '_': new Date().getTime()
                }
                ,success: function(res){
                    if(res.code == 0){
                        layer.msg(res.message);
                        table.reload('adminListTable', {
                            url: path+"admin/getAllAdmin"
                            ,page: {curr: 1}
                        });
                    }else{
                        layer.msg(res.message);
                    }
                }
            });
        }, function(){
            return;
        });
    }
};

function disableAdmin(data, path, table)
{
    if(data.status != 0)
    {
        layer.msg("管理员"+data.loginName+"已禁用，已取消此操作！");
    }else{
        layer.confirm('是否禁用管理员 '+data.loginName,{
            title: '禁用管理员'
            ,btn: ['禁用','返回']
        }, function(){
            var csrf = $("meta[name = '_csrf']").attr("content");
            $.post({
                url: path+'admin/disable'
                ,dataType: 'JSON'
                ,data: {
                    'id': data.id,
                    '_csrf': $("meta[name = '_csrf']").attr("content"),
                    '_csrf_header': $("meta[name = '_csrf_header']").attr("content"),
                    '_': new Date().getTime()
                }
                ,success: function(res)
                {
                    if(res.code == 0){
                        layer.msg(res.message);
                        table.reload('adminListTable', {
                            url: path+"admin/getAllAdmin"
                            ,page: {curr: 1}
                        });
                    }else{
                        layer.msg(res.message);
                    }
                }
            });
        }, function(){
            return;
        });
    }
};

function editAdmin(data, path, table)
{
    var aPath = path, atable = table;
    var edit = '<i class="layui-icon">&#xe605;</i>提交',
        waive = '<i class="layui-icon">&#x1006;</i>返回';

    layer.open({
        type: 2,
        title: '管理员信息',
        area: ['1080px', '780px'],
        offset: 'auto',
        btnAlign: 'r',
        fixed: false,
        maxmin: true,
        shadeClose: true,
        content: path+'admin/view/details/'+data.id,
        btn: [edit, waive],
        yes: function(index, layero){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            var adminDetailsForm = iframeWin.document.getElementById("adminDetailsForm");
            var dataArray = $(adminDetailsForm).serializeArray(), datas = {};
            $.each(dataArray, function(){
                datas[this.name] = this.value;
            });

            $.post({
                url: aPath + 'admin/update',
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
                        atable.reload('adminListTable', {
                            url: path+"admin/getAllAdmin"
                            ,page: {curr: 1}
                        });
                    }else{
                        layer.msg(res.message);

                    }
                },
                error: function(res){
                    layer.msg(res.message);
                }
            })
            return false;
        },
        btn2: function(index, layero){
        }
    });
};

function delAdmin(data, path, table)
{
    var aData = data, aPath = path, atable = table;

    layer.prompt({
        formType: 1,
        title: '请输入登录密码',
        maxlength: 20
    },function(value, index, layero){

        var uri = aPath+'admin/delete/' + value+ '/' + aData.id;
        $.ajax({
            url: uri,
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
                    atable.reload('adminListTable', {
                        url: path+"admin/getAllAdmin"
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
    });
};

function search(laydate, form, table, path)
{
    laydate.render({
        elem: '#createDateRange'
        ,range: true
    });

    form.on('submit(search)',function(data){

        var condit = JSON.stringify(data.field);
        console.log(path+"admin/search/"+condit);
        table.reload('adminListTable', {
            url: path+"admin/search",
            page: {curr: 1},
            where:{
                'condit': condit
            }
        });

        return false;
    });
}

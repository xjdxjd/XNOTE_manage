function render(table, path)
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
            {field: 'status', title: '状态', width: 130, sort: true},
            {field: 'creatorId', title: '创建者ID',hide: true},
            {field: 'creator', title: '创建者', width: 150, templet: '#creatorTPL'},
            {field: 'createTime', title: '创建时间', width: 250, sort: true},
            {field: 'updateTime', title: '更新时间', width: 250, sort: true},
            {field: 'operation', title: '操作', width: 269, toolbar: '#adminListTableOperbar'}
        ]],
        done:function(res, curr, count){
            $("[data-field='status']").children().each(function(){
                if($(this).text() == '0'){
                    $(this).html('<span class="layui-badge layui-bg-green">正常</span>')
                }
                if($(this).text() == '1'){
                    $(this).html('<span class="layui-badge layui-bg-gray">禁用</span>')
                }
                if($(this).text() == '-1'){
                    $(this).html('<span class="layui-badge layui-bg-blue">冻结</span>')
                }
                if($(this).text() == '-2'){
                    $(this).html('<span class="layui-badge layui-bg-orange">锁定</span>')
                }
                if($(this).text() == '-3'){
                    $(this).html('<span class="layui-badge layui-bg-black">作废</span>')
                }
            });
        }
    });

    table.on('tool(adminListTable)', function (d) {
        var data = d.data;
        switch (d.event) {
            case 'enable':
                if(data.status == 0)
                {
                   layer.msg("管理员"+data.loginName+"已启用，已取消此操作！");
                }else{
                    layer.confirm('是否启用管理员 '+data.loginName,{
                        title: '启用管理员'
                        ,btn: ['启用','返回']
                    }, function(){
                        $.post({
                            url: ROOT_PATH+'admin/getAdmin/'+data.id
                            ,dataType: 'JSON'
                            ,success: function(res){
                                if(res.code == 0){
                                    layer.msg(res.message);
                                    table.reload('adminTable', {
                                        url: '${req.contextPath}/adminManage/getAdminList'
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
                break;

            case 'disable':
                if(data.status != 0)
                {
                    layer.msg("管理员"+data.loginName+"已禁用，已取消此操作！");
                }else{
                    layer.confirm('是否禁用管理员 '+data.loginName,{
                        title: '禁用管理员'
                        ,btn: ['禁用','返回']
                    }, function(){
                        $.post({
                            url: ROOT_PATH+'admin/getAdmin/'+data.id
                            ,dataType: 'JSON'
                            ,success: function(res)
                            {
                                if(res.code == 0){
                                    layer.msg(res.message);
                                    table.reload('adminTable', {
                                        url: '${req.contextPath}/adminManage/getAdminList'
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
                break;

            case 'edit':
                layer.open({
                    type: 2,
                    title: '管理员信息',
                    area: ['1080px', '780px'],
                    fixed: false,
                    maxmin: true,
                    content: ROOT_PATH+'admin/details/'+data.id
                });
                break;

            case 'del':

                break;
        }
    });

}

//  表单状态改为可写
$('#writeable').click(function() {
    $('#edit').removeClass("layui-btn-disabled");
    $('.writeabled').removeAttr('readonly');
});

//  提交表单
$('#edit').click(function(){

});
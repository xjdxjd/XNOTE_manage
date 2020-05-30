function render(table, path)
{
    table.render({
        elem: '#adminListTable',
        url: path+"admin/getAllAdmin",
        height: 500,
        toolbar: '#adminListTableTopbar',
        title: '管理员表',
        page: true,
        cols: [[
            {type: 'checkbox', fixed: 'left'},
            {field: 'index', title: '序号', width:80},
            {field: 'id', title: 'ID', sort: true,  hide: true},
            {field: 'loginName', title: '登录名', width:160, sort: true},
            {field: 'adminName', title: '管理员名称', width:160, sort: true},
            {field: 'sort', title: '排序', width:100, sort: true},
            {field: 'status', title: '状态', width: 130, sort: true},
            {field: 'creatorId', title: '创建者ID',hide: true},
            {field: 'creator', title: '创建者', width: 150},
            {field: 'createTime', title: '创建时间', width: 250, sort: true},
            {field: 'updateTime', title: '更新时间', width: 250, sort: true},
            {field: 'operation', title: '操作',toolbar: '#adminListTableOperbar', width: 269}
        ]]
    });
}
layui.use(['form','table'], function () {
    var form = layui.form,
        table = layui.table;


/******************************************************************************************************/
/* ========================================【 管理员登录日志 】 ======================================== */
/******************************************************************************************************/
    table.render({
        id: 'adminLoginLogsTable',
        elem: '#admin-login-logs-table',
        url: PATH + "log/alLogs/getLogs",
        title: '管理员登录日志表',
        page: true,
        height: 'full-242',
        limit: 13,
        limits: [5,10,15,20,35,50],
        text: {
            none: '暂无相关数据'
        },
        cols:[[
            {type: 'checkbox'},
            {field: 'index', title: '序号', width:80, type:'numbers'},
            {field: 'logId', title: 'ID', hide: true},
            {field: 'loginName', title: '登录帐号', width:200, align: 'center'},
            {field: 'loginIp', title: 'IP地址', width:200, align: 'center'},
            {field: 'loginType', title: '登录/登出', width:100, templet: '#typeTPL', align: 'center'},
            {field: 'loginStatus', title: '操作结果', width:100, templet: '#statusTPL', align: 'center'},
            {field: 'logContent', title: '日志内容', width:560, align: 'left'},
            {field: 'createTime', title: '记录时间', width:190, align: 'center'},
            {field: 'operation', title: '操作', width: 120, toolbar: '#operation-bar'}
        ]],
        parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
            return {
                "code": res.code, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.data.count, //解析数据长度
                "data": res.data.data //解析数据列表
            };
        }
    });

    table.on('tool(admin-login-logs-table)', function (d) {
        switch(d.event){
            case 'info': getAdminLoginInfo(d.data); break;
        }
    });

    /******************************************************************************************************/
    /* =========================================【 用户登录日志 】 ========================================= */
    /******************************************************************************************************/
    table.render({
        id: 'userLoginLogsTable',
        elem: '#user-login-logs-table',
        url: PATH + "log/ulLogs/getLogs",
        title: '用户登录日志表',
        page: true,
        height: 'full-242',
        limit: 13,
        limits: [5,10,15,20,35,50],
        text: {
            none: '暂无相关数据'
        },
        cols:[[
            {type: 'checkbox'},
            {field: 'index', title: '序号', width:80, type:'numbers'},
            {field: 'logId', title: 'ID', hide: true},
            {field: 'account', title: '登录帐号', width:200, align: 'center'},
            {field: 'loginIp', title: 'IP地址', width:200, align: 'center'},
            {field: 'loginType', title: '登录/登出', width:100, templet: '#typeTPL', align: 'center'},
            {field: 'loginStatus', title: '操作结果', width:100, templet: '#statusTPL', align: 'center'},
            {field: 'logContent', title: '日志内容', width:560, align: 'left'},
            {field: 'createTime', title: '记录时间', width:190, align: 'center'},
            {field: 'operation', title: '操作', width: 120, toolbar: '#oper-bar'}
        ]],
        parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
            return {
                "code": res.code, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.data.count, //解析数据长度
                "data": res.data.data //解析数据列表
            };
        }
    });

    table.on('tool(user-login-logs-table)', function (d) {
        switch(d.event){
            case 'info': getUserLoginInfo(d.data); break;
        }
    });
/******************************************************************************************************/
/* ========================================【 客户端运行日志 】 ======================================== */
/******************************************************************************************************/
    table.render({
        id: 'clientRunLogsTable',
        elem: '#client-run-logs-table',
        url: PATH + "log/clientLogs/getlogs",
        title: '客户端运行日志表',
        page: true,
        height: 'full-242',
        limit: 13,
        limits: [5,10,15,20,35,50],
        text: {
            none: '暂无相关数据'
        },
        cols:[[
            {type: 'checkbox'},
            {field: 'index', title: '序号', width:80, type:'numbers'},
            {field: 'logId', title: 'ID', hide: true},
            {field: 'runningIp', title: 'IP地址', width:130, align: 'center'},
            {field: 'runningType', title: '类型', width:100, templet: '#typeTPL', align: 'center'},
            {field: 'runningResult', title: '运行结果', width:100, templet: '#resultTPL', align: 'center'},
            {field: 'logContent', title: '日志内容', width:415, align: 'left'},
            {field: 'failureCause', title: '失败原因', width:415, align: 'left'},
            {field: 'createTime', title: '记录时间', width:190, align: 'center'},
            {field: 'operation', title: '操作', width: 120, toolbar: '#oper-bar'}
        ]],
        parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
            return {
                "code": res.code, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.data.count, //解析数据长度
                "data": res.data.data //解析数据列表
            };
        }
    });

    table.on('tool(client-run-logs-table)', function (d) {
        switch(d.event){
            case 'info': getclientRunInfo(d.data); break;
        }
    });
});

function getAdminLoginInfo(data)
{
    layer.open({
        type: 2,
        title: '日志详细信息',
        area: ['1080px', '580px'],
        offset: 'auto',
        fixed: false,
        maxmin: true,
        shadeClose: true,
        content: PATH + 'log/alLogs/getlog/'+data.logId
    });
}

function getUserLoginInfo(data)
{
    layer.open({
        type: 2,
        title: '日志详细信息',
        area: ['1080px', '580px'],
        offset: 'auto',
        fixed: false,
        maxmin: true,
        shadeClose: true,
        content: PATH + 'log/ulLogs/getlog/'+data.logId
    });
}

function getclientRunInfo(data)
{
    layer.open({
        type: 2,
        title: '日志详细信息',
        area: ['1080px', '580px'],
        offset: 'auto',
        fixed: false,
        maxmin: true,
        shadeClose: true,
        content: PATH + 'log/clientLogs/getlog/'+data.logId
    });
}
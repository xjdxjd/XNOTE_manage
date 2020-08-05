layui.use(['form','table'], function () {
    var form = layui.form,
        table = layui.table;

   table.render({
       id: 'adminLoginLogsTable',
       elem: '#admin-login-logs-table',
       url: PATH + "log/adminLogin/getLogs",
       height: 'full-203',
       title: '管理员登录日志表',
       page: true,
       limits: [5,10,20,30,40,50],
       text: {
           none: '暂无相关数据'
       },
       cols:[[
           {type: 'checkbox'},
           {field: 'index', title: '序号', width:80, type:'numbers'},
           {field: 'logId', title: 'ID', sort: true, hide: true},
           {field: 'loginName', title: '登录者', width:200, align: 'center'},
           {field: 'loginIp', title: 'IP地址', width:200, align: 'center'},
           {field: 'loginType', title: '登录/登出', width:100, templet: '#typeTPL', align: 'center'},
           {field: 'loginStatus', title: '操作结果', width:100, templet: '#statusTPL', align: 'center'},
           {field: 'logContent', title: '日志内容', width:546, align: 'left'},
           {field: 'createTime', title: '记录时间', width:200, align: 'center'},
           {field: 'operation', title: '操作', width: 124, toolbar: '#operation-bar', align: 'center'}
       ]],
       parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
           return {
               "code": res.code, //解析接口状态
               "msg": res.message, //解析提示文本
               "count": res.data.count, //解析数据长度
               "data": res.data.data //解析数据列表
           };
       }
   })
});
layui.use(['form','table'], function(){
   var form = layui.form;
   var table = layui.table;

   table.render({
       id: 'resListTable',
       elem: '#res_list_table',
       url: PATH + "res/getList",
       title: '小工具资源列表',
       toolbar: '#top-bar',
       page: true,
       height: 'full-242',
       limit: 13,
       limits: [13,15,20,35,50],
       text: {
           none: '暂无相关数据'
       },
       cols:[[
           {type: 'checkbox'},
           {field: 'index', title: '序号', width:80, type:'numbers'},
           {field: 'resId', title: 'ID', hide: true},
           {field: 'resTitle', title: '资源名称', width:150, align: 'center'},
           {field: 'resIcon', title: '资源图标', width:100, align: 'center', templet: function (d) {
                   return '<div><img src="../resDownIcon/'+d.resIcon+'"></div>'
               }},
           {field: 'resDesc', title: '资源描述', width:592, align: 'left'},
           {field: 'resUrl', title: '资源真实路径', width:400, align: 'left'},
           {field: 'downNub', title: '下载量', width:90, align: 'center'},
           {field: 'uploadTime', title: '上传时间', width:190, align: 'center'},
           {field: 'operation', title: '操作', width: 160, align: 'center', toolbar: '#oper-bar'}
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

   table.on('tool(res_list_table)', function (d) {
       switch (d.event)
       {
           case 'edit': editView(d.data); break;
           case 'upIcon': resetIcon(d.data); break;
       }
   });

   table.on('toolbar(res_list_table)', function (d) {
      switch (d.event)
      {
          case 'add': addView(); break;
      }
   });

});

function editView(data)
{
    layer.open({
        type: 2,
        title: '编辑资源配置',
        area: ['1080px', '600px'],
        offset: 'auto',
        btnAlign: 'r',
        fixed: false,
        maxmin: true,
        shadeClose: true,
        content: PATH + 'res/resource/' + data.resId,
        btn: [
            '<i class="layui-icon">&#xe642;</i>更新',
            '<i class="layui-icon">&#xe666;</i>返回'
        ]
    });
}

function resetIcon(data)
{
    layer.open({
        type: 2,
        title: '更新资源图标',
        area: ['400px', '340px'],
        offset: 'auto',
        btnAlign: 'r',
        fixed: false,
        maxmin: false,
        shadeClose: true,
        content: PATH + 'res/resetIcon/' + data.resId
        /*,
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
        }*/
    });
}

function addView()
{
    layer.open({
        type: 2,
        title: '<span style="color: #35A9FF;"><i class="layui-icon">&#xe624;</i>&nbsp;&nbsp;上传资源</span>',
        area: ['1080px', '650px'],
        offset: 'auto',
        btnAlign: 'r',
        fixed: false,
        maxmin: true,
        shadeClose: true,
        content: PATH + 'res/add',
        btn: [
            '<i class="layui-icon">&#xe624;</i>添加',
            '<i class="layui-icon">&#xe666;</i>返回'
        ],
        yes: function(index, layero){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            var resForm = iframeWin.document.getElementById("resForm");
            var dataArray = $(resForm).serializeArray(), datas = {};
            $.each(dataArray, function(){
                datas[this.name] = this.value;
            });

            $.ajax({
                url: PATH + 'res/add',
                type: 'PUT',
                dataType: 'JSON',
                data: {
                    'data': JSON.stringify(datas),
                    '_csrf': $(iframeWin.document.getElementsByName("_csrf")).attr("content"),
                    '_csrf_header': $(iframeWin.document.getElementsByName("_csrf_header")).attr("content"),
                    '_': new Date().getTime()
                },
                success: function(res){
                    if(res.code == 0){
                        layer.msg(res.message);
                       /* atable.reload('adminListTable', {
                            url: path+"admin/getAllAdmin"
                            ,page: {curr: 1}
                        });*/
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
}
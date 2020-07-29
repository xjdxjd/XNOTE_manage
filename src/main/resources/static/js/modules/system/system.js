function loadForegroundConfig(form, path)
{
    $.get({
        url: path + "system/client/getSetting",
        dataType: 'json',
        success: function (res) {
            if(res.code == 0){
                var clientSet = res.data;
                form.val("systemForegroundConfig", {
                    "projectTitle": clientSet['projectTitle'].configValue,
                    "logoText": clientSet['logoText'].configValue,
                    "clientNotice": clientSet['clientNotice'].configValue,
                    "clientCopyright": clientSet['clientCopyright'].configValue
                });
            }
            return false;
        }
    });

    $.get({
        url: path + "system/client/getUserFunc",
        dataType: 'json',
        success: function (res) {
            if(res.code == 0){
                var clientSet = res.data;
                form.val("systemFrontModuleSwitch", {
                    "version": clientSet['version'].funcSwitch,
                    "login": clientSet['login'].funcSwitch,
                    "regist": clientSet['regist'].funcSwitch,
                    "add": clientSet['add'].funcSwitch,
                    "comment": clientSet['comment'].funcSwitch,
                    "star": clientSet['star'].funcSwitch,
                    "message": clientSet['message'].funcSwitch,
                    "search": clientSet['search'].funcSwitch,
                    "course": clientSet['course'].funcSwitch,
                    "resourceDown": clientSet['resourceDown'].funcSwitch,
                    "about": clientSet['about'].funcSwitch
                });
            }
            return false;
        }
    });


}

function systemForegroundConfig (form, path)
{
    form.verify({
        /*
    "projectTitle": function (value, item) {
        if(!new RegExp("^[^\\s]*$").test(value)){
            return "项目名称不能为空且不能包含空格";
        }
        if(!new RegExp("^[a-z0-9\u4E00-\u9FFF]{4,20}$").test(value)){
            return "项目名称长度为4-20位";
        }
        if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5]+$").test(value)){
            return "项目名称不能含有特殊字符";
        }
        if(new RegExp("^\\d+\\d+\\d$").test(value)){
            return "项目名称不能全为数字";
        }
        if(!new RegExp("^[^_]+$").test(value)){
            return "项目名称首尾不能出现下划线'_'";
        }
    },
    "logoText":  function (value, item) {
        if(!new RegExp("^[^\\s]*$").test(value)){
            return "logo标题不能为空且不能包含空格";
        }
        if(!new RegExp("^[a-z0-9\u4E00-\u9FFF]{4,20}$").test(value)){
            return "logo标题长度为4-20位";
        }
        if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5]+$").test(value)){
            return "logo标题不能含有特殊字符";
        }
        if(new RegExp("^\\d+\\d+\\d$").test(value)){
            return "logo标题不能全为数字";
        }
        if(!new RegExp("^[^_]+$").test(value)){
            return "logo标题首尾不能出现下划线'_'";
        }
    },
    "clientNotice":  function (value, item) {
        if(!new RegExp("^[^\\s]*$").test(value)){
            return "logo标题不能为空且不能包含空格";
        }
        if(!new RegExp("^[a-z0-9\u4E00-\u9FFF]{0,255}$").test(value)){
            return "logo标题长度为4-20位";
        }
    },
    "clientCopyright":  function (value, item) {
        if(!new RegExp("^[^\\s]*$").test(value)){
            return "logo标题不能为空且不能包含空格";
        }
        if(!new RegExp("^[a-z0-9\u4E00-\u9FFF]{4,20}$").test(value)){
            return "logo标题长度为4-20位";
        }
        if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5]+$").test(value)){
            return "logo标题不能含有特殊字符";
        }
        if(new RegExp("^\\d+\\d+\\d$").test(value)){
            return "logo标题不能全为数字";
        }
        if(!new RegExp("^[^_]+$").test(value)){
            return "logo标题首尾不能出现下划线'_'";
        }
    }
    */
    });

    //  字段提交
    form.on('submit(foregroundSub)',function (data) {

        $.post({
            url: path + 'system/client/ssfc/update',
            dataType: 'json',
            data: {
                'formData': JSON.stringify(data.field),
                '_csrf': $("meta[name = '_csrf']").attr("content"),
                '_csrf_header': $("meta[name = '_csrf_header']").attr("content"),
                '_': new Date().getTime()
            },
            success: function (res) {
                layer.msg(res.message);
            }
        });
        return false;
    });
    // 开关提交
    form.on('submit(frontModuleSwitch)',function (data) {

        $.post({
            url: path + 'system/client/ufunc/save',
            dataType: 'json',
            data: {
                'formData': JSON.stringify(data.field),
                '_csrf': $("meta[name = '_csrf']").attr("content"),
                '_csrf_header': $("meta[name = '_csrf_header']").attr("content"),
                '_': new Date().getTime()
            },
            success: function (res) {
                layer.msg(res.message);
            }
        });
        return false;
    });
}



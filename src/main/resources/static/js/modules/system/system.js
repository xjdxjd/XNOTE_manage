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

                form.val("systemFrontModuleSwitch", {
                    "projectVersion": clientSet['projectVersion'].configValue,
                    "loginSwitch": clientSet['loginSwitch'].configValue,
                    "registSwitch": clientSet['registSwitch'].configValue,
                    "addNoteSwitch": clientSet['addNoteSwitch'].configValue,
                    "commentSwitch": clientSet['commentSwitch'].configValue,
                    "messageSwitch": clientSet['messageSwitch'].configValue,
                    "courseSwitch": clientSet['courseSwitch'].configValue,
                    "resDown": clientSet['resDown'].configValue
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
            url: path + 'system/client/ssfms/save',
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



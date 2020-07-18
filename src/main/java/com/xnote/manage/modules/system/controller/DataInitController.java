package com.xnote.manage.modules.system.controller;

import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class DataInitController extends BaseController
{
    ///////////////////////////////////////////////////[ 系统配置界面 ]////////////////////////////////////////////////////

    @RequestMapping("/dataInit")
    public String dataInitView()
    {
        return LoadPathConstant.SYSTEM_DATAINIT_PATH.getValue()+"init";
    }


    ///////////////////////////////////////////////////[ 系统配置功能 ]////////////////////////////////////////////////////
}

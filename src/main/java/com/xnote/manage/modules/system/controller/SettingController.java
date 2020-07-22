package com.xnote.manage.modules.system.controller;

import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xiaojundi_xx
 */
@Controller
public class SettingController extends BaseController
{
    @RequestMapping(value = "/system/clientSetting", method = RequestMethod.GET)
    public String clientSettingView(){
        return LoadPathConstant.SYSTEM_CLIENT_SETTING_PATH.getValue() + "setting";
    }
}

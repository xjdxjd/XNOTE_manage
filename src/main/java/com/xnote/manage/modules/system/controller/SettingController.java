package com.xnote.manage.modules.system.controller;

import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaojundi_xx
 */
@Controller
@RequestMapping("/system")
public class SettingController extends BaseController
{
    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/clientSetting", method = RequestMethod.GET)
    public String clientSettingView()
    {
        return LoadPathConstant.SYSTEM_CLIENT_SETTING_PATH.getValue() + "setting";
    }

    @GetMapping("/client/getSetting")
    @ResponseBody
    public Result getClientSetting()
    {
        Map<String, SysConfig> cliCfgMap = new HashMap<>();

        List<SysConfig> clientcfgs = systemService.getSystemClientConfig();
        for (SysConfig clientcfg : clientcfgs) {
            cliCfgMap.put(clientcfg.getConfigCode(), clientcfg);
        }

        return result.success(cliCfgMap);
    }

    @PostMapping("/client/ssfc/save")
    @ResponseBody
    public Result saveSysForegroundConfig()
    {

        return result.success();
    }

    @PostMapping("/client/uploadLogo")
    @ResponseBody
    public Result uploadClientLogo(@RequestParam("file") MultipartFile file)
    {

        return result.success();
    }

    @PostMapping("/client/ssfms/save")
    @ResponseBody
    public Result saveSysFrontModuleSwitch()
    {

        return result.success();
    }




}

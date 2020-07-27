package com.xnote.manage.modules.system.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
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

        List<SysConfig> clientcfgs = systemService.getSystemConfig(CommonConstant.SYSCFG_TYPE_CLIENT.getInt());
        for (SysConfig clientcfg : clientcfgs) {
            cliCfgMap.put(clientcfg.getConfigCode(), clientcfg);
        }

        return result.success(cliCfgMap);
    }

    @PostMapping("/client/ssfc/update")
    @ResponseBody
    public Result updateSysForegroundConfig(@RequestParam("formData") String formData) throws JsonProcessingException
    {
        List<SysConfig> clientCfgs = new ArrayList<>();
        if(StringUtils.isEmpty(formData))
        {
            return result.failure();
        }

        Map<String, Object> configMap = new ObjectMapper().readValue(formData, Map.class);
        List<SysConfig> clientcfgs = systemService.getSystemConfig(CommonConstant.SYSCFG_TYPE_CLIENT.getInt());
        for (SysConfig sysConfig : clientcfgs)
        {
                if(ObjectUtils.isEmpty(configMap.get(sysConfig.getConfigCode())))
                {
                    continue;
                }else{
                    sysConfig.setConfigValue((String)configMap.get(sysConfig.getConfigCode()));
                    clientCfgs.add(sysConfig);
                }
        }

        List<SysConfig> cfgs = systemService.updateSystemConfig(clientcfgs, clientCfgs, CommonConstant.SYSCFG_TYPE_CLIENT.getInt());
        if(CollectionUtils.isEmpty(cfgs))
        {
            return result.failure();
        }
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
    public Result updateSysFrontModuleSwitch(@RequestParam("formData") String formData) throws JsonProcessingException {

        List<SysConfig> clientCfgs = new ArrayList<>();
        if(StringUtils.isEmpty(formData))
        {
            return result.failure();
        }

        Map<String, Object> configMap = new ObjectMapper().readValue(formData, Map.class);
        List<SysConfig> clientcfgs = systemService.getSystemConfig(CommonConstant.SYSCFG_TYPE_CLIENT.getInt());
        for (SysConfig sysConfig : clientcfgs)
        {
            if(ObjectUtils.isEmpty(configMap.get(sysConfig.getConfigCode())))
            {
                continue;
            }else{
                sysConfig.setConfigValue((String)configMap.get(sysConfig.getConfigCode()));
                clientCfgs.add(sysConfig);
            }
        }

        List<SysConfig> cfgs = systemService.updateSystemConfig(clientcfgs, clientCfgs, CommonConstant.SYSCFG_TYPE_CLIENT.getInt());
        if(CollectionUtils.isEmpty(cfgs))
        {
            return result.failure();
        }
        return result.success();
    }




}

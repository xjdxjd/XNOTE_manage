package com.xnote.manage.modules.system.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.common.constant.system.ConfigConstant;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.service.SystemService;
import com.xnote.manage.modules.user.bean.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/client/getUserFunc")
    @ResponseBody
    public Result getClientFunction()
    {
        Map<String, UserFunction> cliFuncMap = new HashMap<>();

        List<UserFunction> userFunctions = systemService.getUserFunction(CommonConstant.FUNCTION_USER_CACHENAME.getString());
        for (UserFunction userFunction : userFunctions) {
            cliFuncMap.put(userFunction.getFuncCode(), userFunction);
        }
        return result.success(cliFuncMap);
    }

    @PostMapping("/client/ufunc/save")
    @ResponseBody
    public Result updateSysFrontModuleSwitch(@RequestParam("formData") String formData) throws JsonProcessingException {

        List<UserFunction> clientCfgs = new ArrayList<>();
        if(StringUtils.isEmpty(formData))
        {
            return result.failure();
        }

        Map<String, Object> configMap = new ObjectMapper().readValue(formData, Map.class);
        List<UserFunction> clientcfgs = systemService.getUserFunction(CommonConstant.FUNCTION_USER_CACHENAME.getString());
        for (UserFunction userFunction : clientcfgs)
        {
            if(ObjectUtils.isEmpty(configMap.get(userFunction.getFuncCode())))
            {
                continue;
            }else{
                userFunction.setFuncSwitch(configMap.get(userFunction.getFuncCode()).toString());
                clientCfgs.add(userFunction);
            }
        }

        List<UserFunction> cfgs = systemService.updateUserFunction(CommonConstant.FUNCTION_USER_CACHENAME.getString(), clientCfgs);
        if(CollectionUtils.isEmpty(cfgs))
        {
            return result.failure();
        }
        return result.success();
    }

    /**
     * 更改配色方案
     * @param theme
     * @return
     */
    @PostMapping("/manage/changecolorscheme")
    @ResponseBody
    public Result changeColorScheme(@RequestParam("theme") String theme, HttpSession session)
    {
        if(StringUtils.isEmpty(theme))
        {
            return result.failure(ConfigConstant.CONFIG_OPERTATION_CODE.code(), ConfigConstant.CONFIG_CHANGE_COLOR_SCHEME_FAILURE_MSG.msg());
        }

        Map<String, SysConfig> sysConfigMap = (Map<String, SysConfig>) session.getAttribute("sysConfig");
        if (CollectionUtils.isEmpty(sysConfigMap))
        {
            return result.failure(ConfigConstant.CONFIG_OPERTATION_CODE.code(), ConfigConstant.CONFIG_CHANGE_COLOR_SCHEME_FAILURE_MSG.msg());
        }

        List<SysConfig> clientcfgs = systemService.getSystemConfig(CommonConstant.SYSCFG_TYPE_MANAGE.getInt());

        for (SysConfig cfg : clientcfgs)
        {
            if(ConfigConstant.CONFIG_CODE_THEME.msg().equals(cfg.getConfigCode()) && cfg.getConfigValue() != theme)
            {
                cfg.setConfigValue(theme);
                sysConfigMap.put(ConfigConstant.CONFIG_CODE_THEME.msg(), cfg);
            }
        }

        systemService.updateSystemConfig(clientcfgs, clientcfgs, CommonConstant.SYSCFG_TYPE_MANAGE.getInt());
        return result.success(ConfigConstant.CONFIG_OPERTATION_CODE.code(), ConfigConstant.CONFIG_CHANGE_COLOR_SCHEME_SUCCESS_MSG.msg());
    }
}

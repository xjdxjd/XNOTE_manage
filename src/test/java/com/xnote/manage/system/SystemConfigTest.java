package com.xnote.manage.system;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.service.SystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @DESC:
 * @ClassName: SystemConfigTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemConfigTest 
{
    @Autowired
    private SystemService systemService;
    
    @Test
    public void getManageSystemConfig()
    {
        List<SysConfig> manageSystemConfig = systemService.getSystemConfig(CommonConstant.SYSCFG_TYPE_MANAGE.getInt());
        for (SysConfig sysConfig :manageSystemConfig )
        {
            System.out.println(sysConfig.getConfigCode()+" == "+sysConfig.getConfigName()+" == "+sysConfig.getConfigValue());
        }
        Map<String, SysConfig> sysConfigMap = new HashMap<>();
        for (SysConfig sysConfig : manageSystemConfig) {
            sysConfigMap.put(sysConfig.getConfigCode(),sysConfig);
        }
        System.out.println(sysConfigMap.size());
    }
}

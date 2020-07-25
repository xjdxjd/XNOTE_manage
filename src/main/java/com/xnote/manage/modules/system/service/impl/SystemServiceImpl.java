package com.xnote.manage.modules.system.service.impl;

import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.mapper.SysConfigMapper;
import com.xnote.manage.modules.system.service.SystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DESC:   系统配置service实现类
 * @ClassName: SystemServiceImpl
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService
{
    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public List<SysConfig> getManageSystemConfig()
    {
        List<SysConfig> manageSysConfigs = sysConfigMapper.getManageSystemConfig();
        return manageSysConfigs;
    }

    @Override
    public List<SysConfig> getSystemClientConfig()
    {
        List<SysConfig> clientSysConfigs = sysConfigMapper.getSystemClientConfig();
        return clientSysConfigs;
    }
}

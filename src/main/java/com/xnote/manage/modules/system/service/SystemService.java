package com.xnote.manage.modules.system.service;

import com.xnote.manage.modules.system.bean.SysConfig;

import java.util.List;

/**
 * @DESC:   系统配置service
 * @ClassName: SystemService
 */
public interface SystemService
{

    /**
     * @DESC:   获取系统配置
     * @methodName: getManageSystemConfig
     */
    public List<SysConfig> getManageSystemConfig();

    /**
     * @DESC:   获取系统前台配置
     * @methodName: getSystemClientConfig
     */
    public List<SysConfig> getSystemClientConfig();

}

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
     * @DESC:   根据configType获取系统配置
     * @methodName: getSystemConfig
     */
    public List<SysConfig> getSystemConfig(Integer configType);

    /**
     * 更新系统前台配置
     * @methodName: updateSysForegroundConfig
     * @param clientcfgs 原数据
     * @param clientCfgs 更新后的数据
     * @return
     */
    public List<SysConfig> updateSystemConfig(List<SysConfig> clientcfgs, List<SysConfig> clientCfgs, Integer configType);
}

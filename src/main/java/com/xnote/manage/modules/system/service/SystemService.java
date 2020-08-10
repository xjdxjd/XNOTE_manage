package com.xnote.manage.modules.system.service;

import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.user.bean.UserFunction;

import java.util.List;

/**
 * @DESC:   系统配置service
 * @ClassName: SystemService
 */
public interface SystemService
{
    /**
     * 根据configType获取系统配置
     * @param configType
     * @return
     */
    public List<SysConfig> getSystemConfig(Integer configType);

    /**
     * 更新系统配置
     * @param clientcfgs 原数据
     * @param clientCfgs 更新后的数据
     * @return
     */
    public List<SysConfig> updateSystemConfig(List<SysConfig> clientcfgs, List<SysConfig> clientCfgs, Integer configType);

    /**
     * 获取全部客户端功能
     * @return
     */
    public List<UserFunction> getUserFunction(String cacheName);

    /**
     * 更新用户功能启停状态
     * @return
     */
    public List<UserFunction> updateUserFunction(String userFuncName, List<UserFunction> userFunctions);
}

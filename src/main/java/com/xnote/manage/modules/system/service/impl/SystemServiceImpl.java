package com.xnote.manage.modules.system.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.core.redis.RedisUtils;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.mapper.SysConfigMapper;
import com.xnote.manage.modules.system.service.SystemService;
import com.xnote.manage.modules.user.bean.UserFunction;
import com.xnote.manage.modules.user.mapper.UserFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

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
    @Resource
    private UserFunctionMapper userFunctionMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    @Cacheable(value = "systemConfig", key = "#p0")
    public List<SysConfig> getSystemConfig(Integer configType)
    {
        List<SysConfig> manageSysConfigs = sysConfigMapper.getSystemConfig(configType);

        return manageSysConfigs;
    }

    @Override
    @CachePut(value = "systemConfig", key = "#p2")
    public List<SysConfig> updateSystemConfig(List<SysConfig> clientcfgs, List<SysConfig> clientCfgs, Integer configType)
    {
        if(CollectionUtils.isEmpty(clientcfgs) || CollectionUtils.isEmpty(clientCfgs) || ObjectUtils.isEmpty(configType))
        {
            return null;
        }

        Integer row = sysConfigMapper.updateSystemConfig(clientCfgs, configType);
        if(CommonConstant.STATUS_ZERO.equals(row))
        {
            return null;
        }
        return clientcfgs;
    }

    @Override
    @Cacheable(value = "userfuncs", key = "#p0")
    public List<UserFunction> getUserFunction(String cacheName)
    {
        //  获取功能
        List<UserFunction> userFuncs = userFunctionMapper.getUserFunction();
        return userFuncs;
    }

    @Override
    @CachePut(value = "userfuncs", key = "#p0")
    public List<UserFunction> updateUserFunction(String cacheName, List<UserFunction> userFunctions)
    {
        if (CollectionUtils.isEmpty(userFunctions))
        {
            return null;
        }

        //  修正次级功能的状态
        for (UserFunction func: userFunctions)
        {
            //  如果客户端版本为user
            if("version".equals(func.getFuncCode()) && "user".equals(func.getFuncSwitch()))
            {
                //  一级功能为关闭状态，则次级功能将全部关闭
                userFunctions = correctStatusOfSecFunctions(userFunctions);
                break;
            }
        }

        userFunctionMapper.updateUserFuncSwitch(userFunctions);

        return userFunctions;
    }

    public List<UserFunction> correctStatusOfSecFunctions(List<UserFunction> funcs)
    {
        for (UserFunction func : funcs)
        {
            if(CommonConstant.FUNCTION_USER_SECONDARY.getInt().equals(func.getFuncType()))
            {
                func.setFuncSwitch(CommonConstant.FUNCTION_USER_SECONDARY_STATUS_STOP.getString());
            }
        }
        return funcs;
    }
}

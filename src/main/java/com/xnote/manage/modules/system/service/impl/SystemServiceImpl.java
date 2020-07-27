package com.xnote.manage.modules.system.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.core.redis.RedisUtils;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.mapper.SysConfigMapper;
import com.xnote.manage.modules.system.service.SystemService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
    @Autowired
    private RedisUtils redisUtils;

    @Override
    @RabbitListener(queues = "atguigu.news")
    @Cacheable(value = "systemConfig", key = "#p0")
    public List<SysConfig> getSystemConfig(Integer configType)
    {
        List<SysConfig> manageSysConfigs = sysConfigMapper.getSystemConfig(configType);
        return manageSysConfigs;
    }

    @Override
    @RabbitListener(queues = "atguigu.news")
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
}

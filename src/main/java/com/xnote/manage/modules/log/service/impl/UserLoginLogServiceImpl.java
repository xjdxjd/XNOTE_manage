package com.xnote.manage.modules.log.service.impl;

import com.xnote.manage.modules.log.bean.UserLoginLog;
import com.xnote.manage.modules.log.mapper.UserLoginLogMapper;
import com.xnote.manage.modules.log.service.UserLoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserLoginLogServiceImpl implements UserLoginLogService
{
    @Resource
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    public Integer getCount() {
        return userLoginLogMapper.getCount();
    }

    @Override
    public List<UserLoginLog> getLogs(Integer pageCode, Integer pageSize)
    {
        if(ObjectUtils.isEmpty(pageCode))
        {
            return null;
        }

        List<UserLoginLog> logs = userLoginLogMapper.getLogs((pageCode - 1) * pageSize, pageSize);

        return logs;
    }
}

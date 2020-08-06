package com.xnote.manage.modules.log.service.impl;

import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.common.util.UUIDUtils;
import com.xnote.manage.modules.log.bean.AdminLoginLog;
import com.xnote.manage.modules.log.mapper.AdminLoginLogMapper;
import com.xnote.manage.modules.log.service.AdminLoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 *  管理员登录日志service
 */
@Service
public class AdminLoginLogServiceImpl implements AdminLoginLogService
{
    @Resource
    private AdminLoginLogMapper adminLoginLogMapper;

    @Override
    public Integer getCount()
    {
        return adminLoginLogMapper.getCount();
    }

    @Override
    public List<AdminLoginLog> getLogs(Integer pageCode, Integer pageSize)
    {
        if(ObjectUtils.isEmpty(pageCode))
        {
            return null;
        }

        List<AdminLoginLog> logs = adminLoginLogMapper.getLogs((pageCode - 1) * pageSize, pageSize);

        return logs;
    }

    @Override
    public Integer saveAdminLoginLog(AdminLoginLog log)
    {
        if(ObjectUtils.isEmpty(log))
        {
            return 0;
        }

        if(ObjectUtils.isEmpty(log.getLoginName()) || ObjectUtils.isEmpty(log.getLoginType()) || ObjectUtils.isEmpty(log.getLoginStatus()))
        {
            return 0;
        }

        if(ObjectUtils.isEmpty(log.getLogId()))
        {
            log.setLogId(UUIDUtils.getUUID());
        }

        if(ObjectUtils.isEmpty(log.getCreateTime()))
        {
            log.setCreateTime(DateUtils.getCurrentDate());
        }

        if(ObjectUtils.isEmpty(log.getTimestamp()))
        {
            log.setTimestamp(DateUtils.getTimestamp());
        }
        Integer row = adminLoginLogMapper.insertLog(log);
        return row;
    }

    @Override
    public AdminLoginLog getLogInfoById(String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return null;
        }

        AdminLoginLog log = adminLoginLogMapper.getLogInfoById(id);
        return log;
    }
}

package com.xnote.manage.modules.log.service.impl;

import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.common.util.UUIDUtils;
import com.xnote.manage.modules.log.bean.ManageOperLog;
import com.xnote.manage.modules.log.mapper.ManageOperLogMapper;
import com.xnote.manage.modules.log.service.ManageOperLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class ManageOperLogServiceImpl implements ManageOperLogService
{
    @Resource
    private ManageOperLogMapper molMapper;

    @Override
    public Integer saveAdminLoginLog(ManageOperLog log)
    {
        if(ObjectUtils.isEmpty(log))
        {
            return 0;
        }

        if(ObjectUtils.isEmpty(log.getLoginName()) || ObjectUtils.isEmpty(log.getOperateType()) || ObjectUtils.isEmpty(log.getOperateResult()))
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
        Integer row = molMapper.insertLog(log);
        return row;
    }
}

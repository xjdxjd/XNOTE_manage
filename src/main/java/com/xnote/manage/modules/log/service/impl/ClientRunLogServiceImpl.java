package com.xnote.manage.modules.log.service.impl;

import com.xnote.manage.modules.log.bean.ClientRunLog;
import com.xnote.manage.modules.log.mapper.ClientRunLogMapper;
import com.xnote.manage.modules.log.service.ClientRunLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientRunLogServiceImpl implements ClientRunLogService
{
    @Resource
    private ClientRunLogMapper clientRunLogMapper;

    @Override
    public Integer getCount()
    {
        return clientRunLogMapper.getCount();
    }

    @Override
    public List<ClientRunLog> getLogs(Integer pageCode, Integer pageSize)
    {
        if(ObjectUtils.isEmpty(pageCode))
        {
            return null;
        }

        List<ClientRunLog> logs = clientRunLogMapper.getLogs((pageCode - 1) * pageSize, pageSize);

        return logs;
    }

    @Override
    public ClientRunLog getLogInfoById(String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return null;
        }

        ClientRunLog log = clientRunLogMapper.getLogInfoById(id);
        return log;
    }
}

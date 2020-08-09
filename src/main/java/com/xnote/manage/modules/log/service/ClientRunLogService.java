package com.xnote.manage.modules.log.service;

import com.xnote.manage.modules.log.bean.ClientRunLog;

import java.util.List;

public interface ClientRunLogService
{
    /**
     * 获取日志总数
     * @return
     */
    Integer getCount();

    /**
     * 获取全部日志记录
     * @param pageCode
     * @param pageSize
     * @return
     */
    List<ClientRunLog> getLogs(Integer pageCode, Integer pageSize);

    /**
     * 根据ID获取日志全部信息
     * @param id
     * @return
     */
    ClientRunLog getLogInfoById(String id);
}

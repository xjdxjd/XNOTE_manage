package com.xnote.manage.modules.log.service;

import com.xnote.manage.modules.log.bean.UserLoginLog;

import java.util.List;

public interface UserLoginLogService
{
    /**
     * 获取日志总数
     * @return
     */
    Integer getCount();

    /**
     * 获取全部日志记录
     * @return
     */
    List<UserLoginLog> getLogs(Integer pageCode, Integer pageSize);

    /**
     * 根据id获取用户登录日志
     * @param id
     * @return
     */
    UserLoginLog getLogInfoById(String id);
}

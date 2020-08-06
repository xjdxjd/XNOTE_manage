package com.xnote.manage.modules.log.service;

import com.xnote.manage.modules.log.bean.AdminLoginLog;

import java.util.List;

/**
 *  管理员登录日志service
 */
public interface AdminLoginLogService
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
    List<AdminLoginLog> getLogs(Integer pageCode, Integer pageSize);

    /**
     * 保存日志记录
     * @param adminLoginLog
     */
    Integer saveAdminLoginLog(AdminLoginLog adminLoginLog);

    /**
     * 根据ID获取日志全部信息
     * @param id
     * @return
     */
    AdminLoginLog getLogInfoById(String id);
}

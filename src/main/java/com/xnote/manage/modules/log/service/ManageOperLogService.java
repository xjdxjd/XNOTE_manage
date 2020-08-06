package com.xnote.manage.modules.log.service;

import com.xnote.manage.modules.log.bean.ManageOperLog;

public interface ManageOperLogService
{

    /**
     * 保存日志记录
     * @param manageOperLog
     */
    Integer saveAdminLoginLog(ManageOperLog manageOperLog);
}

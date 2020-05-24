package com.xnote.manage.modules.function.service;

import com.xnote.manage.modules.function.bean.AdminFunction;

import java.util.List;

/**
 * @DESC:   管理员功能service
 * @InterfaceName: AdminFuncService
 */
public interface AdminFuncService
{
    /**
     * @DESC: 根据管理员id获取管理员功能
     * @methodName: getAdminFuncByAdminId
     */
    public List<AdminFunction> getAdminFuncByRoleId(String id);
}

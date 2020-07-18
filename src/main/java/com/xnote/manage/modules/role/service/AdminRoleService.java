package com.xnote.manage.modules.role.service;

import com.xnote.manage.modules.role.bean.AdminRole;

import java.util.List;

/**
 * @DESC:   管理员角色service
 * @ClassName: AdminRoleService
 */
public interface AdminRoleService
{
    /**
     * @DESC:   根据管理员id获取管理员角色
     * @methodName: gteRoleByAdminId
     */
    public AdminRole getRoleById(String id);

    /**
     * @DESC:   获取全部管理员角色
     * @methodName: getRoleList
     */
    public List<AdminRole> getRoleList();
}

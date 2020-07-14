package com.xnote.manage.modules.admin.service;

import com.xnote.manage.modules.admin.bean.Admin;

import java.util.List;

/**
 * @DESC:   管理员操作service
 * @InterfaceName: AdminService
 */
public interface AdminService
{
    /**
     * @DESC:   获取所有管理员账号信息
     * @methodName: getAdminList
     */
    public List<Admin> getAdminList();

    /**
     * @DESC:   根据管理员id获取管理员账号信息
     * @methodName: getAdminById
     */
    public Admin getAdminById(String id);

    /**
     * @DESC:   添加管理员
     * @methodName: insertAdmin
     */
    public int insertAdmin(Admin admin);

    /**
     * @DESC:   更新管理员
     * @methodName: updateAdmin
     */
    public int updateAdmin(Admin admin);

    /**
     * @DESC:   删除管理员
     * @methodName: deleteAdmin
     */
    public int deleteAdmin(String id);

    /**
     * @DESC:   启用管理员
     * @methodName: enableAdmin
     */
    public String enableAdmin(String id);

    /**
     * @DESC:   禁用管理员
     * @methodName: disableAdmin
     */
    public String disableAdmin(String id);

    /**
     * @DESC:   管理员是否存在
     * @methodName: isEmpty
     */
    public boolean isEmpty(String id);
}

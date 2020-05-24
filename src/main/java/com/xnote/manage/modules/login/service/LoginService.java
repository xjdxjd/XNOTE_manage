package com.xnote.manage.modules.login.service;

import com.xnote.manage.modules.admin.bean.Admin;

/**
 * @DESC:   登录service
 * @ClassName: LoginService
 */
public interface LoginService
{
    /*
     *  根据登录名获取管理员
     */
    public Admin getAdminByLoginName(String loginName);

    /*
     *  更新登录者信息
     */
    public boolean updateLogin(String ipaddr, Admin admin);
}

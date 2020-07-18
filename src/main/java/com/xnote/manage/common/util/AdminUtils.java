package com.xnote.manage.common.util;

import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.login.bean.LoginAdmin;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @DESC:   管理员工具类
 * @ClassName: AdminUtils
 */
public class AdminUtils {

    public static boolean isRequiredEmpty(Admin admin)
    {
        boolean isEmpty = false;
        if(StringUtils.isEmpty(admin.getId()) ||
                StringUtils.isEmpty(admin.getLoginName()) ||
                StringUtils.isEmpty(admin.getAdminName()) ||
                StringUtils.isEmpty(admin.getPassword()) ||
                ObjectUtils.isEmpty(admin.getStatus()) ||
                ObjectUtils.isEmpty(admin.getSort()) ||
                StringUtils.isEmpty(admin.getAdminEmail()))
        {
            isEmpty = true;
        }

        return isEmpty;
    }

    public static void completionField(Admin admin, HttpSession session)
    {
        admin.setId(UUIDUtils.getUUID());
        admin.setPassword(LoginUtils.encrypt(admin.getLoginName()));

        LoginAdmin loginAdmin = (LoginAdmin) session.getAttribute("loginAdmin");
        admin.setCreatorId(loginAdmin.getId());
        admin.setCreator(loginAdmin.getName());

        admin.setCreateTime(DateUtils.getCurrentDate());
        admin.setUpdateTime(DateUtils.getCurrentDate());
        admin.setTimestamp(DateUtils.getTimestamp());
    }

}

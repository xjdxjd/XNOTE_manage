package com.xnote.manage.common.util;

import com.xnote.manage.modules.admin.bean.Admin;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
                StringUtils.isEmpty(admin.getRole()) ||
                StringUtils.isEmpty(admin.getAdminEmail()))
        {
            isEmpty = true;
        }

        return isEmpty;
    }
}

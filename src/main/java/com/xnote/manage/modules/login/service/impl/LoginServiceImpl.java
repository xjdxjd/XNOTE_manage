package com.xnote.manage.modules.login.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.admin.mapper.AdminMapper;
import com.xnote.manage.modules.login.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @DESC:   登录service实现类
 * @ClassName: LoginServiceImpl
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService
{
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByLoginName(String loginName)
    {
        if(StringUtils.isEmpty(loginName))
        {
            return null;
        }
        Admin admin = adminMapper.getAdminByLoginName(loginName);

        return admin;
    }

    @Override
    public boolean updateLogin(String ipaddr, Admin admin)
    {
        boolean isFaild = false;
        if (ObjectUtils.isEmpty(admin))
        {
            isFaild = true;
        }

        Date date = DateUtils.getCurrentDate();
        admin.setLoginIp(ipaddr);
        admin.setLoginTime(date);
        admin.setUpdateTime(date);
        admin.setTimestamp(DateUtils.getTimestamp());

        int count = adminMapper.updateLogin(admin);
        if (count == CommonConstant.RESULT_FAILD_ZERO.getInt())
        {
            isFaild = true;
        }

        return isFaild;
    }
}

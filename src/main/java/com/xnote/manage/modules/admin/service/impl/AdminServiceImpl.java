package com.xnote.manage.modules.admin.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.admin.AdminConstant;
import com.xnote.manage.common.util.AdminUtils;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.admin.mapper.AdminMapper;
import com.xnote.manage.modules.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DESC:   管理员操作service实现类
 * @ClassName: AdminServiceImpl
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService
{
    private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Resource
    private AdminMapper adminMapper;

    public List<Admin> getAdminList()
    {
        List<Admin> adminList = adminMapper.getAdminList();

        logger.info("获取管理员列表");
        return adminList;
    }

    @Override
    public Admin getAdminById(String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return null;
        }

        Admin admin = adminMapper.getAdminById(id);
        return admin;
    }

    @Override
    public int insertAdmin(Admin admin)
    {
        int count = -1;

        boolean isEmpty = AdminUtils.isRequiredEmpty(admin);
        if(isEmpty)
        {
            return count = AdminConstant.ADMIN_INSERT_FAILD_CODE_1202;
        }

        System.out.println(admin.toString());

        List<String> ids = adminMapper.isExsit(admin.getId(), admin.getLoginName());
        if(CommonConstant.STATUS_NORMAL.getInt() != ids.size())
        {
            return count = AdminConstant.ADMIN_INSERT_FAILD_CODE_1203;
        }

        count = adminMapper.insertAdmin(admin);
        if(CommonConstant.RESULT_FAILD_ZERO.getInt() == count)
        {
            return count = AdminConstant.ADMIN_INSERT_FAILD_CODE_1204;
        }
        return count;
    }
}

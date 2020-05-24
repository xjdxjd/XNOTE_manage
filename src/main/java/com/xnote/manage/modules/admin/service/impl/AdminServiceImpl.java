package com.xnote.manage.modules.admin.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.ResultConstant;
import com.xnote.manage.common.util.AdminUtils;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.admin.mapper.AdminMapper;
import com.xnote.manage.modules.admin.service.AdminService;
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
    @Resource
    private AdminMapper adminMapper;

    public List<Admin> getAdminList()
    {
        List<Admin> adminList = adminMapper.getAdminList();
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
//        NormalResult result = new NormalResult();

        boolean isEmpty = AdminUtils.isRequiredEmpty(admin);
        if(isEmpty)
        {
            return count = ResultConstant.ADMIN_INSERT_FAILD_CODE_1202;
        }

        System.out.println(admin.toString());

        List<String> ids = adminMapper.isExsit(admin.getId(), admin.getLoginName());
        if(CommonConstant.STATUS_NORMAL != ids.size())
        {
            return count = ResultConstant.ADMIN_INSERT_FAILD_CODE_1203;
        }

        count = adminMapper.insertAdmin(admin);
        if(CommonConstant.RESULT_FAILD_ZERO == count)
        {
            return count = ResultConstant.ADMIN_INSERT_FAILD_CODE_1204;
        }
        return count;
    }
}

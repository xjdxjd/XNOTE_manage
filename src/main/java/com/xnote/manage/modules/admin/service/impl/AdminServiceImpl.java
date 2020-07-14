package com.xnote.manage.modules.admin.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.admin.AdminConstant;
import com.xnote.manage.common.util.AdminUtils;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.admin.mapper.AdminMapper;
import com.xnote.manage.modules.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
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

    @Override
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

    @Override
    public int updateAdmin(Admin admin)
    {
        int code = -1;

        if(ObjectUtils.isEmpty(admin))
        {
            return code = AdminConstant.ADMIN_UPDATE_FAILD_CODE_1401;
        }

        Admin oldAdmin = adminMapper.getAdminById(admin.getId());
        if(ObjectUtils.isEmpty(oldAdmin))
        {
            return code = AdminConstant.ADMIN_UPDATE_FAILD_CODE_1403;
        }
        admin.setUpdateTime(DateUtils.getCurrentDate());
        code = adminMapper.updateAdmin(admin);

        return code;
    }

    @Override
    public int deleteAdmin(String id)
    {
        int code = -1;
        if (StringUtils.isEmpty(id))
        {
            return code = AdminConstant.ADMIN_DELETE_FAILD_CODE_1301;
        }

        if(this.isEmpty(id))
        {
            return code = AdminConstant.ADMIN_DELETE_FAILD_CODE_1303;
        }

        code = adminMapper.deleteAdmin(id);


        return code;
    }

    @Override
    public String enableAdmin(String id)
    {
        String message = null;
        if(StringUtils.isEmpty(id))
        {
            message = AdminConstant.ADMIN_ENDI_FAILD_MESSAGE_1501;
        }

        Admin admin = adminMapper.getAdminById(id);
        if(ObjectUtils.isEmpty(admin))
        {
            message = AdminConstant.ADMIN_ENDI_FAILD_MESSAGE_1502;
        }

        admin.setStatus(AdminConstant.ADMIN_STATUS_ENABLE);
        admin.setUpdateTime(DateUtils.getCurrentDate());
        admin.setTimestamp(DateUtils.getTimestamp());

        adminMapper.changeAdminStatus(admin);

        return message;
    };

    @Override
    public String disableAdmin(String id)
    {
        String message = null;
        if(StringUtils.isEmpty(id))
        {
            message = AdminConstant.ADMIN_ENDI_FAILD_MESSAGE_1504;
        }

        Admin admin = adminMapper.getAdminById(id);
        if(ObjectUtils.isEmpty(admin))
        {
            message = AdminConstant.ADMIN_ENDI_FAILD_MESSAGE_1505;
        }

        admin.setStatus(AdminConstant.ADMIN_STATUS_DISABLE);
        admin.setUpdateTime(DateUtils.getCurrentDate());
        admin.setTimestamp(DateUtils.getTimestamp());

        adminMapper.changeAdminStatus(admin);

        return message;
    }

    @Override
    public boolean isEmpty(String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return true;
        }

        Admin admin = adminMapper.getAdminById(id);
        if (ObjectUtils.isEmpty(admin))
        {
            return true;
        }

        return false;
    }
}

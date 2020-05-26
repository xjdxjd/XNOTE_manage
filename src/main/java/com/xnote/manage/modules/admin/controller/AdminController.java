package com.xnote.manage.modules.admin.controller;

import com.xnote.manage.common.constant.ResultConstant;
import com.xnote.manage.common.constant.admin.AdminConstant;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @DESC:
 * @ClassName: AdminController
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController
{
    @Autowired
    private AdminService adminService;

    /**
     * @DESC:   获取所有管理员账号信息
     * @methodName: getAdminList
     */
    @GetMapping("/getAllAdmin")
    public Result getAdminList(HttpServletRequest request, HttpServletResponse response)
    {
        List<Admin> admins = adminService.getAdminList();
        if(CollectionUtils.isEmpty(admins))
        {
            return result.failure(ResultConstant.SELECT_FAILD_CODE, ResultConstant.SELECT_FAILD_MESSAGE,null);
        }

        return result.success(ResultConstant.SELECT_SUCCESS_CODE, ResultConstant.SELECT_SUCCESS_MESSAGE,admins);
    }

    /**
     * @DESC:   根据管理员id获取管理员账号信息
     * @methodName: getAdminById
     */
    @GetMapping("/getAdmin/{id}")
    public Result getAdminById(@PathVariable("id") String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return result.failure(AdminConstant.ADMIN_SELECT_FAILD_CODE_1101, AdminConstant.ADMIN_SELECT_FAILD_MESSAGE_1101, null);
        }

        Admin admin = adminService.getAdminById(id);
        if(ObjectUtils.isEmpty(admin))
        {
            return result.failure(AdminConstant.ADMIN_SELECT_FAILD_CODE_1102, AdminConstant.ADMIN_SELECT_FAILD_MESSAGE_1102, null);
        }

        return result.success(AdminConstant.ADMIN_SELECT_SUCCESS_CODE, AdminConstant.ADMIN_SELECT_SUCCESS_MESSAGE, admin);
    }

    /**
     * @DESC:   添加管理员
     * @methodName: insertAdmin
     */
    @PutMapping("/add")
    public Result insertAdmin(Admin admin)
    {
        if(ObjectUtils.isEmpty(admin))
        {
            return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1201, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1201);
        }

        int count = adminService.insertAdmin(admin);
        switch (count) {
            case 1202:
                return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1202, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1202);

            case 1203:
                return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1203, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1203);

            case 1204:
                return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1204, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1204);
        }
        return result.success(AdminConstant.ADMIN_INSERT_SUCCESS_CODE, AdminConstant.ADMIN_INSERT_SUCCESS_MESSAGE);
    }
}

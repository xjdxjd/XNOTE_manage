package com.xnote.manage.modules.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xnote.manage.common.constant.ResultConstant;
import com.xnote.manage.common.constant.admin.AdminConstant;
import com.xnote.manage.common.util.AdminUtils;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.admin.service.AdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @DESC:   管理员操作控制器
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
    @ApiOperation(value="获取管理员账号列表", notes="获取管理员账号列表，用于反显页面")
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
    @ApiOperation(value="获取管理员账号信息", notes="根据管理员id查找管理员详细信息")
    @ApiImplicitParam(name = "id", value = "管理员ID", required = true, dataType = "String")
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @DESC:   添加管理员
     * @methodName: insertAdmin
     */
    @PutMapping("/add")
    @ApiOperation(value="添加管理员", notes="新建管理员")
    @ApiImplicitParam(name = "formData", value = "表单数据，json格式的字符串", required = true, dataType = "String")
    public Result insertAdmin(@RequestParam("formData") String formData, HttpSession session)
    {
        if(StringUtils.isEmpty(formData))
        {
            return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1201, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1201);
        }

        JSONObject json = JSON.parseObject(formData);
        Admin admin = JSON.toJavaObject(json, Admin.class);
        if(ObjectUtils.isEmpty(admin))
        {
            return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1201, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1201);
        }
        AdminUtils.completionField(admin, session);

        int code = adminService.insertAdmin(admin);
        switch (code) {
            case 1202:
                return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1202, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1202);

            case 1203:
                return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1203, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1203);

            case 1204:
                return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1204, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1204);
        }
        return result.success(AdminConstant.ADMIN_INSERT_SUCCESS_CODE, AdminConstant.ADMIN_INSERT_SUCCESS_MESSAGE);
    }

    /**
     * @DESC:   更新管理员
     * @methodName: updateAdmin
     */
    @PostMapping("/update")
    @ApiOperation(value = "管理员信息更新", notes = "更新管理员")
    @ApiImplicitParam(name = "formData", value = "表单数据，json格式的字符串", required = true, dataType = "String")
    public Result updateAdmin(@RequestParam("formData") String formData)
    {
        if(StringUtils.isEmpty(formData))
        {
            return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1401, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1401);
        }

        JSONObject json = JSON.parseObject(formData);
        Admin admin = JSON.toJavaObject(json, Admin.class);
        if(ObjectUtils.isEmpty(admin))
        {
            return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1402, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1402);
        }

        int code = adminService.updateAdmin(admin);
        switch (code)
        {
            case 1401 :
                return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1401, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1401);

            case 1402 :
                return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1402, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1402);

            case 1403 :
                return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1403, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1403);

            default:
                return result.success(AdminConstant.ADMIN_UPDATE_SUCCESS_CODE, AdminConstant.ADMIN_UPDATE_SUCCESS_MESSAGE);
        }
    }

    /**
     * @DESC:   删除管理员
     * @methodName: deleteAdmin
     */
    @DeleteMapping("/delete/{pass}/{id}")
    @ApiOperation(value = "删除管理员", notes = "删除管理员")
    @ApiImplicitParam(name = "id", value = "管理员ID", required = true, dataType = "String")
    public Result deleteAdmin(@PathVariable("pass") String pass, @PathVariable("id") String id)
    {
        if (StringUtils.isEmpty(pass) || StringUtils.isEmpty(id))
        {
            return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1301, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1301);
        }




        boolean empty = adminService.isEmpty(id);
        if(empty)
        {
            return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1303, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1303);
        }

        int code = adminService.deleteAdmin(id);
        switch (code)
        {
            case 1301 :
                return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1401, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1401);

            case 1302 :
                return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1402, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1402);

            case 1303 :
                return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1403, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1403);

            default:
                return result.success(AdminConstant.ADMIN_DELETE_SUCCESS_CODE, AdminConstant.ADMIN_DELETE_SUCCESS_MESSAGE);
        }
    }

    /**
     * @DESC:   批量删除管理员
     * @methodName: batchesDelAdmin
     */
    @DeleteMapping("/batchesDel")
    @ApiOperation(value = "启用管理员", notes = "启用管理员")
    @ApiImplicitParam(name = "ids", value = "管理员IDs", required = true, dataType = "String")
    public Result batchesDelAdmin(@RequestParam("ids") String ids)
    {
        if (StringUtils.isEmpty(ids))
        {
            return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1301, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1301);
        }

        return result.success();
    }

    /**
     * @DESC:   启用管理员
     * @methodName: enableAdmin
     */
    @PostMapping("/enable")
    @ApiOperation(value = "启用管理员", notes = "启用管理员")
    @ApiImplicitParam(name = "id", value = "管理员ID", required = true, dataType = "String")
    public Result enableAdmin(@RequestParam("id") String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return result.failure(AdminConstant.ADMIN_ENDI_FAILD_MESSAGE_1501);
        }

        String message = adminService.enableAdmin(id);
        if(!StringUtils.isEmpty(message))
        {
            return result.failure(message);
        }

        return result.success();
    }

    /**
     * @DESC:   禁用管理员
     * @methodName: disableAdmin
     */
    @PostMapping("/disable")
    @ApiOperation(value = "禁用管理员", notes = "禁用管理员")
    @ApiImplicitParam(name = "id", value = "管理员ID", required = true, dataType = "String")
    public Result disableAdmin(@RequestParam("id") String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return result.failure(AdminConstant.ADMIN_ENDI_FAILD_MESSAGE_1504);
        }

        String message = adminService.disableAdmin(id);
        if(!StringUtils.isEmpty(message))
        {
            return result.failure(message);
        }

        return result.success();
    }
}

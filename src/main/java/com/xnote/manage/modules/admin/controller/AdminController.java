package com.xnote.manage.modules.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xnote.manage.common.constant.ResultConstant;
import com.xnote.manage.common.constant.admin.AdminConstant;
import com.xnote.manage.common.util.AdminUtils;
import com.xnote.manage.common.util.LoginUtils;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.admin.service.AdminService;
import com.xnote.manage.modules.login.bean.LoginAdmin;
import com.xnote.manage.modules.role.service.AdminRoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private AdminRoleService adminRoleService;

    /**
     * @DESC:   获取所有管理员账号信息
     * @methodName: getAdminList
     */
    @GetMapping("/getAllAdmin")
    @ApiOperation(value="获取管理员账号列表", notes="获取管理员账号列表，用于反显页面")
    public Result getAdminList(HttpServletRequest request, HttpServletResponse response)
    {
        List<Admin> admins = adminService.getAdminList();

        Map<String, Object> adminsMap = new HashMap<>();
        adminsMap.put("data", admins);
        adminsMap.put("count",  admins.size());
        return result.success(ResultConstant.SELECT_SUCCESS_CODE, ResultConstant.SELECT_SUCCESS_MESSAGE,adminsMap);
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
    public Result insertAdmin(@RequestParam("formData") String formData, HttpSession session) throws JsonProcessingException {
        if(StringUtils.isEmpty(formData))
        {
            return result.failure(AdminConstant.ADMIN_INSERT_FAILD_CODE_1201, AdminConstant.ADMIN_INSERT_FAILD_MESSAGE_1201);
        }
        ObjectMapper mapper = new ObjectMapper();
        Admin admin = mapper.readValue(formData, Admin.class);
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
    public Result updateAdmin(@RequestParam("formData") String formData) throws JsonProcessingException {
        if(StringUtils.isEmpty(formData))
        {
            return result.failure(AdminConstant.ADMIN_UPDATE_FAILD_CODE_1401, AdminConstant.ADMIN_UPDATE_FAILD_MESSAGE_1401);
        }

        Admin admin = new ObjectMapper().readValue(formData, Admin.class);
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
    public Result deleteAdmin(HttpSession session, @PathVariable("pass") String pass, @PathVariable("id") String id)
    {
        if (StringUtils.isEmpty(pass) || StringUtils.isEmpty(id))
        {
            return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1301, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1301);
        }

        String landerPass = LoginUtils.encrypt(pass);
        LoginAdmin loginAdmin = (LoginAdmin) session.getAttribute("loginAdmin");
        if(loginAdmin.getInfo().getPassword().equals(landerPass))
        {
            return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1303, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1303);
        }

        boolean empty = adminService.isEmpty(id);
        if(empty)
        {
            return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1304, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1304);
        }

        int code = adminService.deleteAdmin(id);
        switch (code)
        {
            case 1301 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1301, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1301);

            case 1302 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1302, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1302);

            case 1303 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1303, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1303);

            case 1304 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1304, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1304);

            case 1305 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1305, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1305);

            default:
                return result.success(AdminConstant.ADMIN_DELETE_SUCCESS_CODE, AdminConstant.ADMIN_DELETE_SUCCESS_MESSAGE);
        }
    }

    /**
     * @DESC:   批量删除管理员
     * @methodName: batchesDelAdmin
     */
    @DeleteMapping("/batchesDel")
    @ApiOperation(value = "批量删除管理员", notes = "批量删除管理员")
    @ApiImplicitParam(name = "ids", value = "管理员IDs", required = true, dataType = "String")
    public Result batchesDelAdmin(HttpSession session, @RequestParam("pass") String pass, @RequestParam("ids") String ids) throws JsonProcessingException {
        if (StringUtils.isEmpty(pass) || StringUtils.isEmpty(ids))
        {
            return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1301, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1301);
        }

        String landerPass = LoginUtils.encrypt(pass);
        LoginAdmin loginAdmin = (LoginAdmin) session.getAttribute("loginAdmin");
        if(!loginAdmin.getInfo().getPassword().equals(landerPass))
        {
            return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1303, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1303);
        }
        List<String> delIds = new ObjectMapper().readValue(ids, ArrayList.class);
        int code = adminService.batchesDelAdmin(delIds);
        switch (code)
        {
            case 1301 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1301, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1301);

            case 1302 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1302, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1302);

            case 1303 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1303, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1303);

            case 1304 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1304, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1304);

            case 1305 :
                return result.failure(AdminConstant.ADMIN_DELETE_FAILD_CODE_1305, AdminConstant.ADMIN_DELETE_FAILD_MESSAGE_1305);

            default:
                return result.success(AdminConstant.ADMIN_DELETE_SUCCESS_CODE, AdminConstant.ADMIN_DELETE_SUCCESS_MESSAGE);
        }
    }

    /**
     * @DESC:   按条件查找管理员
     * @methodName: search
     */
    @GetMapping("/search")
    @ApiOperation(value = "按条件搜索管理员帐号", notes = "按条件搜索管理员帐号")
    @ApiImplicitParam(name = "condit", value = "条件JSON字符串", required = true, dataType = "String")
    public Result search(@RequestParam("condit") String condit) throws JsonProcessingException
    {
        Admin admin = new ObjectMapper().readValue(condit, Admin.class);

        Map<String, Object> conditJson = new ObjectMapper().readValue(condit, Map.class);
        String createDateRange = (String) conditJson.get("createDateRange");
        String[] createtims = createDateRange.split(" - ");

        List<Admin> admins = adminService.search(admin, createtims);

        Map<String, Object> adminsMap = new HashMap<>();
        adminsMap.put("data", admins);
        adminsMap.put("count",  admins.size());
        return result.success(ResultConstant.SELECT_SUCCESS_CODE, ResultConstant.SELECT_SUCCESS_MESSAGE,adminsMap);
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

package com.xnote.manage.modules.role.controller;

import com.xnote.manage.common.constant.ResultConstant;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.role.bean.AdminRole;
import com.xnote.manage.modules.role.service.AdminRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/adminRole")
public class AdminRoleController extends BaseController
{
    @Autowired
    private AdminRoleService adminRoleService;

    /**
     * @DESC:   获取所有管理员角色信息
     * @methodName: getAdminRoleList
     * @return
     */
    @GetMapping("/getRoleList")
    @ApiOperation(value="获取管理员账号列表", notes="获取管理员账号列表，用于反显页面")
    public Result getAdminRoleList(HttpServletRequest request, HttpServletResponse response)
    {
        List<AdminRole> roles = adminRoleService.getRoleList();

        Map<String, Object> rolesMap = new HashMap<>();
        rolesMap.put("data", roles);
        rolesMap.put("count",  roles.size());
        return result.success(ResultConstant.SELECT_SUCCESS_CODE, ResultConstant.SELECT_SUCCESS_MESSAGE,rolesMap);
    }
}

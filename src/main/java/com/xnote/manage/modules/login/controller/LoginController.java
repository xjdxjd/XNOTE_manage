package com.xnote.manage.modules.login.controller;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.ResultConstant;
import com.xnote.manage.common.util.LoginUtils;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.function.bean.AdminFunction;
import com.xnote.manage.modules.function.service.AdminFuncService;
import com.xnote.manage.modules.login.bean.LoginAdmin;
import com.xnote.manage.modules.login.service.LoginService;
import com.xnote.manage.modules.role.bean.AdminRole;
import com.xnote.manage.modules.role.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登录操作Controller
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AdminFuncService adminFuncService;
    /**
     * @DESC:   登录功能
     * @methodName: signIn
     */
    @PostMapping("/signin")
    public Result signIn(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(value = "loginName", required = true) String loginName,
                         @RequestParam(value = "password", required = true) String password,
                         @RequestParam(value = "verifyCode", required = true) String verifyCode)
    {
        // 校验管理员账号
        Admin admin = loginService.getAdminByLoginName(loginName);
        if(ObjectUtils.isEmpty(admin))
        {
            return result.failure(ResultConstant.LOGIN_FAILD_CODE_1001, ResultConstant.LOGIN_FAILD_MESSAGE_1001, ResultConstant.LOGIN_FAILD_URL);
        }
        // 检查管理员账号状态
        else if(!admin.getStatus().equals(CommonConstant.STATUS_NORMAL))
        {
            return result.failure(ResultConstant.LOGIN_FAILD_CODE_1002, ResultConstant.LOGIN_FAILD_MESSAGE_1002, ResultConstant.LOGIN_FAILD_URL);
        }

        // 校验管理员密码
        String pwdEncrypt = LoginUtils.encrypt(password);
        if (StringUtils.isEmpty(pwdEncrypt) || pwdEncrypt.equals(admin.getPassword()))
        {
            return result.failure(ResultConstant.LOGIN_FAILD_CODE_1003, ResultConstant.LOGIN_FAILD_MESSAGE_1003, ResultConstant.LOGIN_FAILD_URL);
        }

        // 校验验证码
        String code = (String) request.getSession().getAttribute("verifyCode");
        if(StringUtils.isEmpty(code) || !code.equals(verifyCode))
        {
            return result.failure(ResultConstant.LOGIN_FAILD_CODE_1004, ResultConstant.LOGIN_FAILD_MESSAGE_1004, ResultConstant.LOGIN_FAILD_URL);
        }

        // 获取管理员角色
        AdminRole adminRole = adminRoleService.getRoleById(admin.getRole());
        if(ObjectUtils.isEmpty(adminRole))
        {
            return result.failure(ResultConstant.LOGIN_FAILD_CODE_1005, ResultConstant.LOGIN_FAILD_MESSAGE_1005, ResultConstant.LOGIN_FAILD_URL);
        }
        // 检查管理员角色状态
        else if(!adminRole.getRoleStatus().equals(CommonConstant.STATUS_NORMAL))
        {
            return result.failure(ResultConstant.LOGIN_FAILD_CODE_1002, ResultConstant.LOGIN_FAILD_MESSAGE_1002, ResultConstant.LOGIN_FAILD_URL);
        }

        // 获取管理员功能权限
        List<AdminFunction> adminFunctions = adminFuncService.getAdminFuncByRoleId(adminRole.getId());

        // 更新管理员信息
        String loginIP = LoginUtils.getLoginIP(request);
        boolean isFaild = loginService.updateLogin(loginIP, admin);
        if(isFaild)
        {
            return error.error(ResultConstant.COMMON_ERROR_CODE, ResultConstant.COMMON_ERROR_MESSAGE);
        }

        // 将管理员账号、管理员权限、管理员功能放入session
        LoginAdmin loginAdmin = new LoginAdmin(admin, adminRole, adminFunctions);
        request.getSession().setAttribute("loginAdmin",loginAdmin);

        System.out.println(result.success(ResultConstant.LOGIN_SUCCESS_CODE, ResultConstant.LOGIN_SUCCESS_MESSAGE, ResultConstant.LOGIN_SUCCESS_URL));
        return result.success(ResultConstant.LOGIN_SUCCESS_CODE, ResultConstant.LOGIN_SUCCESS_MESSAGE, ResultConstant.LOGIN_SUCCESS_URL);
    }

    @GetMapping("/signout")
    public Result signOut(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.invalidate();
        return result.success(ResultConstant.LOGOUT_SUCCESS_CODE, ResultConstant.LOGOUT_SUCCESS_MESSAGE, ResultConstant.LOGIN_SUCCESS_URL);
    }
}

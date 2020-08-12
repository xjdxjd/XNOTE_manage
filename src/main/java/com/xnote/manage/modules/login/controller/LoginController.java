package com.xnote.manage.modules.login.controller;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.ResultConstant;
import com.xnote.manage.common.constant.login.LoginConstant;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> resMap = new HashMap<>();

        // 校验管理员账号
        Admin admin = loginService.getAdminByLoginName(loginName);
        if(ObjectUtils.isEmpty(admin))
        {
            resMap.put("loginName", loginName);
            resMap.put("url", LoginConstant.LOGIN_FAILD_URL);
            return result.failure(LoginConstant.LOGIN_FAILD_CODE_1001, LoginConstant.LOGIN_FAILD_MESSAGE_1001, resMap);
        }

        //  检查管理员是否已经登录
        HttpSession session = request.getSession();
        if(!ObjectUtils.isEmpty(session.getAttribute("loginAdmin")))
        {
            LoginAdmin loginAdmin = (LoginAdmin) session.getAttribute("loginAdmin");
            if(loginAdmin.getInfo().getLoginName().equals(loginName))
            {
                resMap.put("loginName", loginAdmin.getName());
                resMap.put("url", LoginConstant.LOGIN_SUCCESS_URL);
                return result.failure(LoginConstant.LOGIN_FAILD_CODE_1006, LoginConstant.LOGIN_FAILD_MESSAGE_1006, resMap);
            }
        }

        // 检查管理员账号状态
        if(!admin.getStatus().equals(CommonConstant.STATUS_NORMAL.getInt()))
        {
            resMap.put("loginName", loginName);
            resMap.put("url", LoginConstant.LOGIN_FAILD_URL);
            return result.failure(LoginConstant.LOGIN_FAILD_CODE_1002, LoginConstant.LOGIN_FAILD_MESSAGE_1002,resMap);
        }

        // 校验管理员密码
        String pwdEncrypt = LoginUtils.encrypt(password);
        if (StringUtils.isEmpty(pwdEncrypt) ||!pwdEncrypt.equals(admin.getPassword()))
        {
            resMap.put("loginName", loginName);
            resMap.put("url", LoginConstant.LOGIN_FAILD_URL);
            return result.failure(LoginConstant.LOGIN_FAILD_CODE_1003, LoginConstant.LOGIN_FAILD_MESSAGE_1003, resMap);
        }

        // 校验验证码
        String code = (String) request.getSession().getAttribute("vCode");
        if(StringUtils.isEmpty(code) || !code.equals(verifyCode))
        {
            resMap.put("loginName", loginName);
            resMap.put("url", LoginConstant.LOGIN_FAILD_URL);
            return result.failure(LoginConstant.LOGIN_FAILD_CODE_1004, LoginConstant.LOGIN_FAILD_MESSAGE_1004,resMap);
        }

        // 获取管理员角色
        AdminRole adminRole = adminRoleService.getRoleById(admin.getRole());
        if(ObjectUtils.isEmpty(adminRole))
        {
            resMap.put("loginName", loginName);
            resMap.put("url", LoginConstant.LOGIN_FAILD_URL);
            return result.failure(LoginConstant.LOGIN_FAILD_CODE_1005, LoginConstant.LOGIN_FAILD_MESSAGE_1005, resMap);
        }
        // 检查管理员角色状态
        else if(!adminRole.getRoleStatus().equals(CommonConstant.STATUS_NORMAL.getInt()))
        {
            resMap.put("loginName", loginName);
            resMap.put("url", LoginConstant.LOGIN_FAILD_URL);
            return result.failure(LoginConstant.LOGIN_FAILD_CODE_1002, LoginConstant.LOGIN_FAILD_MESSAGE_1002, resMap);
        }

        // 获取管理员功能权限
        List<AdminFunction> adminFunctions = adminFuncService.getAdminFuncByRoleId(adminRole.getId());

        // 更新管理员信息
        String loginIP = LoginUtils.getLoginIP(request);
        admin.setLoginIp(loginIP);
        boolean isFaild = loginService.updateLogin(admin);
        if(isFaild)
        {
            resMap.put("loginName", loginName);
            resMap.put("url", LoginConstant.LOGIN_FAILD_URL);
            return result.failure(ResultConstant.COMMON_ERROR_CODE, ResultConstant.COMMON_ERROR_MESSAGE, resMap);
        }

        // 将管理员账号、管理员权限、管理员功能放入session
        LoginAdmin loginAdmin = new LoginAdmin(admin, adminRole, adminFunctions);
        session.setAttribute("loginAdmin",loginAdmin);

        resMap.put("admin", loginAdmin);
        resMap.put("url", LoginConstant.LOGIN_SUCCESS_URL);

        return result.success(LoginConstant.LOGIN_SUCCESS_CODE, LoginConstant.LOGIN_SUCCESS_MESSAGE, resMap);
    }

    /**
     * @DESC:   退出登录
     * @methodName: signOut
     */
    @GetMapping("/signout")
    public Result signOut(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        LoginAdmin loginAdmin = (LoginAdmin) session.getAttribute("loginAdmin");

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("admin", loginAdmin);
        resMap.put("url", LoginConstant.LOGOUT_SUCCESS_URL);

        session.invalidate();

        return result.success(LoginConstant.LOGOUT_SUCCESS_CODE, LoginConstant.LOGOUT_SUCCESS_MESSAGE_2001, resMap);
    }
}

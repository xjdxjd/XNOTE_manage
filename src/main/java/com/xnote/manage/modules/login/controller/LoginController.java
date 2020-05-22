package com.xnote.manage.modules.login.controller;

import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.NormalResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录操作Controller
 */
@Controller
@RequestMapping("/login")
@ResponseBody
public class LoginController extends BaseController {

    /**
     * @DESC:   登录功能
     * @methodName: signIn
     */
    @PostMapping("/signin")
    public NormalResult signIn(HttpServletRequest request, HttpServletResponse response,@RequestParam("loginName") String loginName,@RequestParam("password") String password,@RequestParam("verifyCode") String verifyCode)
    {
        System.out.println("==================");
        System.out.println("loginName = " + loginName);
        System.out.println("password = " + password);
        System.out.println("verifyCode = " + verifyCode);
        System.out.println("==================");

        System.out.println(result.success().toString());
        return result.success();
    }
}

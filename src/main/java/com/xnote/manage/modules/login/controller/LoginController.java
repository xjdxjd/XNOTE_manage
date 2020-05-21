package com.xnote.manage.modules.login.controller;

import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.NormalResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录操作Controller
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    /**
     * @DESC:   登录功能
     * @methodName: signIn
     */
    @PostMapping("/signin/{loginName}/{password}/{verifyCode}")
    public NormalResult signIn(HttpServletRequest request, HttpServletResponse response,
                               @PathVariable("loginName") String loginName,
                               @PathVariable("password") String password,
                               @PathVariable("verifyCode") String verifyCode){



        return super.result;
    }
}

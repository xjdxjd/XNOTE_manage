package com.xnote.manage.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @DESC:   加载页面控制器
 * @methodName: LoadController
 */
@Controller
@RequestMapping("/load")
public class LoadController {

    // 登录页面路径
    private static final String LOGIN_PATH = "/modules/login/";

    @GetMapping("/login")
    public String loadLoginView(){

        return LOGIN_PATH+"login";
    }

    @GetMapping({"/","/index","index.html"})
    public String loadIndexView(){

        return "index";
    }
}

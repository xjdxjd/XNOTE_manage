package com.xnote.manage.core.controller;

import com.xnote.manage.common.util.LoginUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * @DESC:   加载页面控制器
 * @methodName: LoadController
 */
@Controller
@RequestMapping("/load")
public class LoadController {

    private String vCode;
    // 登录页面路径
    private static final String LOGIN_PATH = "/modules/login/";
    // 欢迎页
    private static final String WELCOME_PATH = "/common/";

    /**
     * @DESC:   登录页
     * @methodName: loadIndexView
     */
    @GetMapping("/login")
    public String loadLoginView(HttpServletRequest request, HttpServletResponse response){

        return LOGIN_PATH+"login";
    }

    /**
     * @DESC:   主页
     * @methodName: loadIndexView
     */
    @GetMapping("/main")
    public String loadMainView(HttpServletRequest request, HttpServletResponse response){

        return WELCOME_PATH+"welcome";
    }

    /**
     * @DESC:   index页面
     * @methodName: loadIndexView
     */
    @GetMapping({"/","/index","index.html"})
    public String loadIndexView(HttpServletRequest request, HttpServletResponse response){

        return "index";
    }

    @GetMapping("/verifyCode")
    public void loadVerifyCode(String time,HttpServletResponse response, HttpSession session) throws IOException
    {
        Map<String, Object> codeMap = LoginUtils.generateVCode(new Random());
        String codeStr = (String)codeMap.get("codeStr");
        BufferedImage image = (BufferedImage)codeMap.get("image");

        session.setAttribute("verifyCode",codeStr);

        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ImageIO.write(image, "JPEG", response.getOutputStream());

        response.getOutputStream().flush();
    }
}

package com.xnote.manage.core.controller;

import com.xnote.manage.common.util.LoginUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
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

    @GetMapping("/login")
    public String loadLoginView(){

        return LOGIN_PATH+"login";
    }

    @GetMapping({"/","/index","index.html"})
    public String loadIndexView(){

        return "index";
    }

    @GetMapping("/verifyCode")
    public void loadVerifyCode(String time,HttpServletResponse response, HttpSession session) throws IOException
    {
        Map<String, Object> codeMap = LoginUtils.generateVCode(new Random());
        String codeStr = (String)codeMap.get("codeStr");
        BufferedImage image = (BufferedImage)codeMap.get("image");

        session.setAttribute("VerifyCode",codeStr);

        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ImageIO.write(image, "JPEG", response.getOutputStream());

        response.getOutputStream().flush();
    }
}

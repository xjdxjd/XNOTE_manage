package com.xnote.manage.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.omg.CORBA.INTERNAL;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @DESC:   登录工具类
 * @methodName: LoginUtils
 */
public class LoginUtils {

    // 验证码图片宽度
    private static final Integer VCODE_WIDTH = 100;
    // 验证码图片高度
    private static final Integer VCODE_HEIGHT = 50;
    // 验证码长度
    private static final Integer VCODE_LENGTH = 6;
    // 干扰线数量
    private static final Integer INTER_LINES_NUMBER = 4;

    /**
     * 密码摘要
     */
    public static String encrypt(String password)
    {
        if(null == password || "".equals(password))
        {
            return null;
        }
        return DigestUtils.sha1Hex(password);
    }

    /**
     * 获取随机颜色
     */
    public static Color getRandColor(int fc, int bc)
    {
        Random random = new Random();
        if(fc>255) fc = 255;
        if(bc>255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }

    /**
     * 获取随机颜色
     */
    public static Map<String, Object> generateVCode(Random random)
    {
        Map<String, Object> codeMap = new HashMap<String, Object>();

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(VCODE_WIDTH, VCODE_HEIGHT, 1);

        //产生image类的Graphics用于绘制操作
        Graphics graphics = image.getGraphics();//Graphics类的样式
        graphics.setColor(getRandColor(200,250));
        graphics.setFont(new Font("Times New Roman",0,30));
        graphics.fillRect(0, 0, VCODE_WIDTH, VCODE_HEIGHT);

        //绘制干扰线
        for(int i=0; i<INTER_LINES_NUMBER; i++)
        {
            graphics.setColor(getRandColor(130, 200));
            int x = random.nextInt(VCODE_WIDTH);
            int y = random.nextInt(VCODE_HEIGHT);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            graphics.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for(int i=0; i<VCODE_LENGTH; i++)
        {
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            graphics.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            graphics.drawString(rand, 13*i+9, 36);
        }

        graphics.dispose();

        codeMap.put("codeStr",strCode);
        codeMap.put("image",image);

        return codeMap;
    }

}

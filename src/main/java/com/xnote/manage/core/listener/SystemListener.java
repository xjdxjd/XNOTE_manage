package com.xnote.manage.core.listener;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.login.LoginConstant;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.modules.login.bean.LoginAdmin;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @DESC:   加载系统配置项
 * @ClassName: SystemListener
 */
@Component(value = "systemListener")
public class SystemListener implements HttpSessionListener
{
    private final Logger logger = LoggerFactory.getLogger(SystemListener.class);

    @Resource
    private SystemService systemService;

    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(
                se.getSession().getServletContext());
        systemService = applicationContext.getBean(SystemService.class);
        init(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        Map<String, Object> params = new HashMap<>(6);
        if(!ObjectUtils.isEmpty(se.getSession().getAttribute("loginAdmin")))
        {
            //  定义日志内容
            LoginAdmin admin = (LoginAdmin) se.getSession().getAttribute("loginAdmin");
            String logContent = "管理员登出成功, 管理员名称: " + admin.getName()
                    + "  状态码: " + LoginConstant.LOGOUT_SUCCESS_CODE
                    + ", 状态消息: " + LoginConstant.LOGOUT_SUCCESS_MESSAGE_2002
                    + ", 记录时间: " + DateUtils.formatCurrentDate();

            //  输出日志
            logger.info(logContent);
        }
        se.getSession().removeAttribute("sysConfig");

    }

    private void init(HttpSessionEvent se)
    {
        Map<String, SysConfig> sysConfigMap = new HashMap<>();
        List<SysConfig> manageSystemConfig = systemService.getSystemConfig(CommonConstant.SYSCFG_TYPE_MANAGE.getInt());
        for (SysConfig sysConfig : manageSystemConfig) {
            sysConfigMap.put(sysConfig.getConfigCode(),sysConfig);
        }
        HttpSession session = se.getSession();
        session.setAttribute("sysConfig", sysConfigMap);
    }

    public void reload(HttpSessionEvent se)
    {
        init(se);
    }
}

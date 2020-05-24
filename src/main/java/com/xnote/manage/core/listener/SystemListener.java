package com.xnote.manage.core.listener;

import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.system.service.SystemService;
import org.springframework.context.ApplicationContext;
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
public class SystemListener implements HttpSessionListener
{

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
        se.getSession().removeAttribute("sysConfig");

    }

    private void init(HttpSessionEvent se)
    {
        Map<String, SysConfig> sysConfigMap = new HashMap<>();
        List<SysConfig> manageSystemConfig = systemService.getManageSystemConfig();
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

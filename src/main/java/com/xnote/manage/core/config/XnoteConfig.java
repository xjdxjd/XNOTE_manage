package com.xnote.manage.core.config;

import com.xnote.manage.core.listener.SystemListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @DESC:
 * @ClassName: XnoteConfig
 */
@Configuration
public class XnoteConfig {
    @Bean
    public ServletListenerRegistrationBean systemListener()
    {
        ServletListenerRegistrationBean<SystemListener> systemListenerServletListenerRegistrationBean
                = new ServletListenerRegistrationBean<>(new SystemListener());
        return systemListenerServletListenerRegistrationBean;
    }
}

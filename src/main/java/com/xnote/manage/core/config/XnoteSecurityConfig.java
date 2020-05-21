package com.xnote.manage.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @DESC:   xnote spring-security配置类
 * @methodName: XnoteSecurityConfig
 */
@Configuration
public class XnoteSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception{
//        security.formLogin();
    }
}

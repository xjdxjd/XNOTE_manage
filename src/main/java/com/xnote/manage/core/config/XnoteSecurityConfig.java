package com.xnote.manage.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @DESC:   xnote spring-security自定义配置类
 * @methodName: XnoteSecurityConfig
 */
@Configuration
@EnableWebSecurity
public class XnoteSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/**","/druid/**").permitAll();
        http.headers()
                .frameOptions().sameOrigin()
                .httpStrictTransportSecurity().disable();
    }
}

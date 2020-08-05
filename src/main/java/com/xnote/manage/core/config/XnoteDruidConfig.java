package com.xnote.manage.core.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class XnoteDruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return DruidDataSourceBuilder.create().build();
    }

    //  配置Druid监控
    //  1、配置一个管理后台的servlet
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> initParems = new HashMap<>();
        initParems.put("loginUsername", "admin");
        initParems.put("password","123456");
        initParems.put("allow","localhost");//  默认允许所有
        initParems.put("deny", "192.168.31.1");

        bean.setInitParameters(initParems);
        return bean;
    }
    //  2、配置一个web监控的filter
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();

        Map<String, String> initParems = new HashMap<>();
        initParems.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParems);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}

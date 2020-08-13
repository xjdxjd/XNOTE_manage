package com.xnote.manage.core.config;

import com.xnote.manage.core.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @DESC:   Spring-MVC自定义配置类
 * @methodName: XnoteWebMVCConfig
 */
@Configuration
public class XnoteWebMVCConfig implements WebMvcConfigurer
{
    @Value("${xnote.resIconPath}")
    private String RESOURCE_ICON_PATH;

    @Value("${xnote.resStorePath}")
    private String RESOURCE_STORE_PATH;

    @Autowired
    private LoginInterceptor loginInterceptor;


/*
   @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {

    }
*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/favicon.ico")
                .excludePathPatterns("/login")
                .excludePathPatterns("/verifyCode")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/resDownIcon/**")
                .excludePathPatterns("/resDownStore/**")
                .excludePathPatterns("/druid/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/error/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("**/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/resDownIcon/**")
                .addResourceLocations("file:"+ RESOURCE_ICON_PATH);

        registry.addResourceHandler("/resDownStore/**")
                .addResourceLocations("file:"+ RESOURCE_STORE_PATH);
    }
}

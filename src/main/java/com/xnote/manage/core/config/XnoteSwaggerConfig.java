package com.xnote.manage.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @DESC:   Swagger配置类
 * @ClassName: XnoteSwaggerConfig
 */
@Configuration
@EnableSwagger2
public class XnoteSwaggerConfig
{
    /**
     * @DESC:   创建REST风格的API
     * @methodName: createRestApi
     */
    @Bean
    public Docket createRestApi()
    {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.xnote.manage.moudles"))
                .apis(RequestHandlerSelectors.basePackage("com.xnote.manage"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * @DESC:   API内容
     * @methodName: apiInfo
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("XNOTE后台管理系统API文档")
                .version("1.0")
                .build();
        return apiInfo;
    }
}

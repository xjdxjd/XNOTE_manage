package com.xnote.manage.core.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.*;

@Configuration
public class XnoteDruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        DruidDataSource druidDataSource = new DruidDataSource();
        List<Filter> filterList = new ArrayList<>();
        filterList.add(wallFilter());
        druidDataSource.setProxyFilters(filterList);
        return druidDataSource;
//        return DruidDataSourceBuilder.create().build();
    }

    //  配置Druid监控
    /**
     * 1、配置一个管理后台的servlet
     * @return
     */
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

    /**
     * 2、配置一个web监控的filter
     * @return
     */
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();

        Map<String, String> initParems = new HashMap<>();
        initParems.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParems);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

    /**
     * 3、配置防火墙过滤器
     * @return
     */
    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }

    /**
     * 4、配置防火墙
     * @return
     */
    @Bean
    public WallConfig wallConfig()
    {
        WallConfig config = new WallConfig();
        config.setMultiStatementAllow(true);
        config.setNoneBaseStatementAllow(true);
        return config;
    }
}

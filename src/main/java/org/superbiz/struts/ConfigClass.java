package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ConfigClass {

    @Bean
    public FilterRegistrationBean struts2Bean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setName("struts2");
        bean.setFilter(new FilterDispatcher());
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("actionPackages", "com.lq");
        bean.setInitParameters(map);
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean strutscleanupFilterBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setName("struts-cleanup");
        bean.setFilter(new ActionContextCleanUp());
        bean.addUrlPatterns("/*");
        bean.setOrder(2);
        return bean;
    }

    @Bean
    public FilterRegistrationBean sitemeshFilterBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setName("sitemesh");
        bean.setFilter(new PageFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(3);
        return bean;
    }

}

package org.xujin.springboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xujin.springboot.filter.myFilter;
import org.xujin.springboot.listener.MyListener;
import org.xujin.springboot.servlet.MyServlet;

import javax.servlet.ServletContextListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xujin
 * @package-name org.xujin.springboot.config
 * @createtime 2020-02-28 16:13
 */
@Configuration
public class MyServletConfig {
    //定制嵌入式的Service容器相关的规则
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8080);
            }
        };
    }

    //注册三大主键
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new myFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        Map<String,String> map = new HashMap<>();
        map.put("name","xujin");
        filterRegistrationBean.setInitParameters(map);
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
        return new ServletListenerRegistrationBean<ServletContextListener>(new MyListener());
    }
}

package org.xujin.springboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.xujin.springboot.component.LoginHandlerIntercepor;
import org.xujin.springboot.component.MyLocaleReslover;

/**
 * @author xujin
 * @package-name org.xujin.springboot.config
 * @createtime 2020-02-25 14:46
 */
//使用WebMvcConfiguration可以扩展springmvc的功能
@Configuration
//@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/xujin请求，返回success页面
        registry.addViewController("xujin").setViewName("success");
        //registry.addViewController("/").setViewName("login");
    }

    //所有的webmvcConfigureAdapter组件会一起起作用
    @Bean
    public WebMvcConfigurer myWebMvcConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleReslover();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerIntercepor()).addPathPatterns("/**")
//                                                              .excludePathPatterns("/","/index.html","/user/login");
    }


}

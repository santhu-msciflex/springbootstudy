package com.example.demo.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    LogInterceptor logInterceptor ;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(logInterceptor).addPathPatterns("/users");
//        registry.addInterceptor(logInterceptor).addPathPatterns("/users/{id}");
    }
}
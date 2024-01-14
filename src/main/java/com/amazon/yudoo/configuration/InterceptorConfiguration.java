//package com.amazon.yudoo.configuration;
//
//import com.amazon.yudoo.controller.interceptor.HeaderInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class InterceptorConfiguration implements WebMvcConfigurer {
//    HeaderInterceptor headerInterceptor;
//
//    @Autowired
//    public InterceptorConfiguration(HeaderInterceptor headerInterceptor){
//        this.headerInterceptor = headerInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(headerInterceptor);
//    }
//}

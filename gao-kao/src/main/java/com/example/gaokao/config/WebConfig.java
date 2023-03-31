package com.example.gaokao.config;

//import com.example.gaokao.Interceptor.TokenInterceptor;

import com.example.gaokao.Interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */

public class WebConfig implements WebMvcConfigurer {
    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/**");
       // registry.addInterceptor(tokenInterceptor()).excludePathPatterns("/**");

    }
}


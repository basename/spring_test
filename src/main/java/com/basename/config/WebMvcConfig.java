package com.basename.config;

import com.basename.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig{

//    @Bean
    public WebMvcConfigurer webMvcConfigurer (){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            @Order(1)
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new AuthenticationInterceptor())
                        //所有路径都被拦截
                        .addPathPatterns("/**")
                        //添加不拦截的路径
                        .excludePathPatterns("/userLogin", "/css/**", "/images/**", "/js/**", "/login.html");
            }

            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry
                        .addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .allowedMethods("GET","POST","DELETE","PUT","OPTIONS","HEAD")
                        .maxAge(3600);
            }
        };
        return webMvcConfigurer;
    }
}

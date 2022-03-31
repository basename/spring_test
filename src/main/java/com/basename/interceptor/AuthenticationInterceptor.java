package com.basename.interceptor;

import org.apache.catalina.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationInterceptor implements HandlerInterceptor {

    //在请求前处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
        System.out.println(request.getRequestURL());

         User user = (User) request.getSession().getAttribute("USER");

         if (user != null){
             return true;
         }else {
             System.out.println("no login....");
             response.sendRedirect(String.format("%slogin.html", request.getContextPath()));
             return false;
         }
    }

    //请求处理完毕以后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    //请求处理以后视图渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}

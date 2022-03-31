package com.basename.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Component
public class LogFilterRegistrationBean extends FilterRegistrationBean<Filter> {

    @PostConstruct
    public void init(){
        setOrder(2);
        setFilter(new LogFilter());
        setUrlPatterns(List.of("/books/*"));
    }

    class LogFilter implements Filter{

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("===============2222222===============");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}

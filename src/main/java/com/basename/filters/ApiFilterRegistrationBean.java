package com.basename.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Component
public class ApiFilterRegistrationBean extends FilterRegistrationBean<Filter> {

    @PostConstruct
    public void init(){
        setOrder(5);
        setFilter(new ApiFilter());
        setUrlPatterns(List.of("/books/*"));
    }

    class ApiFilter implements Filter{

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("============5555555============");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}

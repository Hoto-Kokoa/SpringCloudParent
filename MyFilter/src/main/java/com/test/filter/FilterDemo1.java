package com.test.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FilterDemo1 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        System.out.println("过滤到转发"+servletRequest1.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}

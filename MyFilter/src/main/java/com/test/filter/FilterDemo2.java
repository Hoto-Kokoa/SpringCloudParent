package com.test.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo2 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化2");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤前2");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤后2");
    }

    public void destroy() {

    }
}

package com.test.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo3 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化3");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤前3");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤后3");
    }

    public void destroy() {

    }
}

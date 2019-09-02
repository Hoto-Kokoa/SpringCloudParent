package com.test.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    private String encoding;
    private boolean force;

    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("Encoding");
        boolean force = Boolean.valueOf(filterConfig.getInitParameter("force"));

        System.out.println("编码格式"+encoding);
        System.out.println("强制编码"+force);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (encoding != null && (servletRequest.getContentType() != null || force))
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);
        System.out.println("过滤到了:"+req.getRequestURI());
        filterChain.doFilter(req,resp);
    }

    public void destroy() {

    }
}

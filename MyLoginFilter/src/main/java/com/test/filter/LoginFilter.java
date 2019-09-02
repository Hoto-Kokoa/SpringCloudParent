package com.test.filter;

import com.sun.org.apache.bcel.internal.generic.FCMPG;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter
{

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String username = (String) req.getSession().getAttribute("username");
        System.out.println(username);
        String requestURI = req.getRequestURI();
        if (!requestURI.equals("/login.jsp") && !requestURI.equals("/login"))
        {
            if (username == null)
            {
                resp.sendRedirect("/login.jsp");
                return;
            }
        }

        filterChain.doFilter(req,resp);
    }

    public void destroy() {

    }
}

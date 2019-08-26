package com.test.servlet;

import javax.servlet.*;
import java.io.IOException;

public class TestServlet implements Servlet {

    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("开始执行业务层");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}

package com.test.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/a", loadOnStartup = 2,initParams = {
        @WebInitParam(name = "name1", value = "1213")
})
public class TestServlet extends HttpServlet {

    //    private static Integer i = 100;
    private ServletConfig servletConfig;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("接收到了Get请求");

//        String name1 = servletConfig.getInitParameter("name1");
//        System.out.println(name1);

//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String s = parameterNames.nextElement();
//            System.out.println(s);
//            System.out.println(req.getParameter(s));
//        }

           System.out.println(req.getParameter("username"));
//        获取配置信息
//        ServletContext servletContext = servletConfig.getServletContext();
//        Enumeration initParameterNames = servletContext.getInitParameterNames();
//        while (initParameterNames.hasMoreElements()) {
//            String a = (String) initParameterNames.nextElement();
//            System.out.println(a+":"+servletContext.getInitParameter(a));
//        }

        //获取资源绝对路径
//        String realPath = servletContext.getRealPath("/com/test/servlet/TestServlet.java");
//        String realPath1 = servletContext.getRealPath("/TestServlet.java");
//        System.out.println(realPath);
//        System.out.println(realPath1);

        //测试转发
//        req.getRequestDispatcher("/TestServletDispatcher").forward(req,resp);

        //测试多线程安全问题
//        try {
//            Thread.currentThread().sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(--i);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("接收到了Post请求");
        String username = req.getParameter("username");
        System.out.println(username);
    }
}

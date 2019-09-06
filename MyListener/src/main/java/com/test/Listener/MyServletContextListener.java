package com.test.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class MyServletContextListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener创建了");
        ArrayList<String> arrayList = new ArrayList();
        servletContextEvent.getServletContext().setAttribute("arrayList", arrayList);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener销毁了");
    }
}

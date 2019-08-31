package com.test.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("网页初始化了");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("网页销毁了");
    }
}

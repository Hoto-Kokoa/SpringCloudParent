package com.test.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@WebListener
public class MySessionListener implements HttpSessionListener {


    public void sessionCreated(final HttpSessionEvent httpSessionEvent) {
        final HttpSession session = httpSessionEvent.getSession();
        final String id = httpSessionEvent.getSession().getId();

        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        final ArrayList<String> arrayList = (ArrayList) servletContext.getAttribute("arrayList");
        arrayList.add(id);
        System.out.println("session创建了"+id);
        for (String s : arrayList) {
            System.out.println("目前array中含有:"+s);
        }

        final Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                       long unActivityTime = System.currentTimeMillis()-session.getLastAccessedTime();
                        System.out.println(id+"未活跃时间:"+unActivityTime);
                        if (unActivityTime > 6000) {
                            session.invalidate();
                            arrayList.remove(id);
                            this.cancel();
                        }
                    }
                }, 2000, 1000
        );

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        String id = httpSessionEvent.getSession().getId();
        System.out.println("session销毁了"+id);
    }
}

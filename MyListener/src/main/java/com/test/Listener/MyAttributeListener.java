package com.test.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("属性增加了:name:"+httpSessionBindingEvent.getName()+"value:"+httpSessionBindingEvent.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("属性移除了:name:"+httpSessionBindingEvent.getName()+"value:"+httpSessionBindingEvent.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("属性修改了:name:"+httpSessionBindingEvent.getName()+"value:"+httpSessionBindingEvent.getValue());
    }
}

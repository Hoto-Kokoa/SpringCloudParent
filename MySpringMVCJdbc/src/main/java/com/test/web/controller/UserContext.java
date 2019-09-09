package com.test.web.controller;

import com.test.domain.Staff;
import com.test.domain.Users;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class UserContext {
    public static HttpSession getSession() {
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())) .getRequest().getSession();  }


    public static void setCurrentUser(Users user) {
        if (user == null) {
            getSession().invalidate();
        }
        else
        {
            getSession().setAttribute("user",user);
        }
    }
    public static Users getCurrentUser(){
        return (Users) getSession().getAttribute("user");
    }
}

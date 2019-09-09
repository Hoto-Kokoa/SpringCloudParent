package com.test.web.interceptor;

import com.test.web.controller.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//拦截器
public class CheckLoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (UserContext.getCurrentUser() == null) {
            response.sendRedirect("/staff/loginPage");
            return false;
//            return true;
        }


        return true;
    }
}

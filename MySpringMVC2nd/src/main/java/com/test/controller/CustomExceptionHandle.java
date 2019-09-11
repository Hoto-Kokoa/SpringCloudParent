package com.test.controller;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CustomExceptionHandle implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //日志文件
        e.printStackTrace();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("exception");
        Map<String, Object> map = new HashMap();
        map.put("exCode", 500);
        map.put("exInfo", e.getMessage());
//        map.put("exDetailInfo",e.)
        mv.addObject("exData", map);

        return mv;
    }
}

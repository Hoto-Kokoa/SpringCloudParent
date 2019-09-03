package cn.wolfcode.hello;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("Hello World");

        ModelAndView mv = new ModelAndView();

        mv.setViewName("/WEB-INF/views/welcome.jsp");

        mv.addObject("msg", "你好SpringMVC");
        return mv;
    }
}

package cn.wolfcode.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public ModelAndView sayHello() {
        System.out.println("执行");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/views/welcome.jsp");
        mv.addObject("msg", "使用注解方式开发SpringMVC");
        return mv;
    }

}

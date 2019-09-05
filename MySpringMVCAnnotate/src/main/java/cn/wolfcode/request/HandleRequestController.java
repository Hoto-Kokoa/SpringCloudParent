package cn.wolfcode.request;


import cn.wolfcode.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/request")
public class HandleRequestController {



    @RequestMapping("/test1")
    public void test1(HttpServletRequest req) {
        System.out.println(req);
    }


//    RESTfull风格传参
    @RequestMapping("/delete/{id}")
    public void test3(@PathVariable("id") Long id) {
        System.out.println(id);

    }


    @RequestMapping("/test4")
    public void test4(Student student) {
        System.out.println(student);
    }
}

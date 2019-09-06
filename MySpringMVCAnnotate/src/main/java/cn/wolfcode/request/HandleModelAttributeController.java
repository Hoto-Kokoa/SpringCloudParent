package cn.wolfcode.request;

import cn.wolfcode.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/b")
public class HandleModelAttributeController {

    @RequestMapping("/11")
    public String test11(Student student) {
        System.out.println(student);
        return "welcome";
    }
}

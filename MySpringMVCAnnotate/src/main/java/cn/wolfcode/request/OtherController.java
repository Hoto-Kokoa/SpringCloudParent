package cn.wolfcode.request;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/other")
@SessionAttributes("errorMsg")
public class OtherController {

    @RequestMapping("/test1")
    public void test1(@RequestHeader("User-agent") String userAgent, @CookieValue("JSESSIONID") String cname) {
        System.out.println("test1");
        System.out.println(userAgent);
        System.out.println(cname);
    }

    @RequestMapping("test2")
    public String test2(Model model) {
        System.out.println(("test2"));
        model.addAttribute("errorMsg", "错误信息");
        return "redirect:/wel.jsp";
    }
}

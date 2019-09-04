package cn.wolfcode.response;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/a")
public class HandleResponseController {

    @RequestMapping("/test2")
    public void test2(OutputStream out) throws IOException {
        Files.copy(Paths.get("C:\\Users\\long\\Desktop\\kokoa.jpg"), out);
    }

    @RequestMapping("test3")
    public ModelAndView test3() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "test3");
        mv.addObject("kokoa");
        mv.setViewName("welcome");
        return mv;
    }


    @RequestMapping("test4")
    public String test4(Model model) {
        model.addAttribute("msg", "kokoa");
        model.addAttribute("qino");
        return "welcome";
    }


    @RequestMapping("test5")
    public String test5(Model model) {
        return "forward:/abc.html";
    }

    @RequestMapping("test6")
    public String test6(Model model) {
        return "redirect:/abc.html";
    }

    @RequestMapping("a1")
    public String a1test(RedirectAttributes ra) {
        ra.addAttribute("msg1", 123);
        ra.addFlashAttribute("msg2", "msg2");
        return "redirect:/a/a2";
    }

    @RequestMapping("a2")
    public ModelAndView a2test(String msg1, @ModelAttribute("msg2") String msg2) {
        System.out.println("msg1" + msg1);
        System.out.println("msg2" + msg2);
        return null;
    }

}

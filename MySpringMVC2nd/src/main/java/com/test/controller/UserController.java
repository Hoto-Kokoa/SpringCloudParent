package com.test.controller;


import com.test.exception.CustomException;
import com.test.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/controller")
@SessionAttributes(value = {"username"})
public class UserController {

    @RequestMapping("test1")
    public String test1() {
        System.out.println("123");
        return "welcome";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginData")
    public String loginData(@RequestBody User user, Model model) {
        System.out.println(user);
        model.addAttribute("username", user.getUsername());
        return "welcome";
    }

    @RequestMapping("/mv")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        modelAndView.addObject("msg", "123");
        return modelAndView;
    }

    @RequestMapping("/error")
    public String error() {
        int a = 1/0;
        return "welcome";
    }


    @RequestMapping("/CustomException")
    public String testCustomException(String username) {
        if (username == null) {
            throw new CustomException("123456");
        }
        return "welcome";
    }
}

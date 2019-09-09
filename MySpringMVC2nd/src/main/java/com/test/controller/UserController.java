package com.test.controller;


import com.test.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller")
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
    public String loginData(User user) {
        System.out.println(user);
        return "welcome";
    }
}

package com.djej.controller;


import com.djej.service.IUserService;
import com.djej.service.Impl.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//@RunWith(SpringJUnit4ClassRunner.class)
@Controller
@RequestMapping("/test")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("test1")
    @ResponseBody
    public String test1() {
        return "123";
    }


    @RequestMapping("test2")
    @ResponseBody
    public String test2() {
        return userService.test2();
    }


    @RequestMapping("test3")
    @ResponseBody
    public String test3() {
        int id = 123;
        return userService.selectByPrimaryKey(id).toString();
    }

}

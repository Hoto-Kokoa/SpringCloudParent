package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.IStudentService;
import com.example.demo.service.impl.StudentServiceImpl;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainActivity {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private IStudentService istudentService;

    @RequestMapping("/findAll")
    @ResponseBody
    public String finAll(HttpSession session) {
        List<Student> student = istudentService.findAll();
        System.out.println(student);
        session.setAttribute("a","123");
        return student.toString();
    }

    @RequestMapping("/wel")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        List<Student> student = istudentService.findAll();
        System.out.println(student);
        mv.addObject("student", student);

        return mv;
    }

    @RequestMapping("/redis")
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("testSpringBootRedis","123");
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public List<Student> testAjax() {
        System.out.println("接受到了请求");
        List<Student> students = istudentService.findAll();
        return students;

    }

    @RequestMapping("/testAdmin")
    @ResponseBody
    public String testAdmin(String username) {
        System.out.println("接收到请求");
        if (username.equals("admin")) {
            System.out.println("ok");
            return "ok";
        }
        else {
            System.out.println("no");
            return "no";
        }
    }
}

package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.IStudentService;
import com.example.demo.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
}

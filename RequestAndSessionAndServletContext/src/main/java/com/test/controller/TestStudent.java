package com.test.controller;


import com.test.domain.Student;
import com.test.service.Impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestStudent {

    @Autowired
    private StudentServiceImpl studentService;

    public List<Student> testSelectAllStudent() {
        List<Student> students = studentService.selectAllStudent();
        System.out.println(students);
        return students;
    }
}

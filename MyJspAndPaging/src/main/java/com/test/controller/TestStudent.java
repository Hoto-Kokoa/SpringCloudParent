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

    @Test
    public void testDeleteStudent() {
        Integer integer = studentService.deleteStudent(987);
        System.out.println(integer);
    }

    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setName("保登心爱");
        Integer integer = studentService.insertStudnent(student);
        System.out.println(integer);
    }

    @Test
    public void testSelectStudentById() {
        Student student = studentService.selectStudentById(1041);
        System.out.println(student);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setName("保登心爱");
        student.setId(995);
        student.setSex("女");
        studentService.updateStudent(student);
    }
}

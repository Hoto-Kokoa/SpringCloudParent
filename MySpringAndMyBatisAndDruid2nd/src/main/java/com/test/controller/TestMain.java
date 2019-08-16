package com.test.controller;


import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import com.test.service.IStudentService;
import com.test.service.Impl.StudentServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMain {

    private IStudentMapper mapper;
    private InputStream resourceAsStream;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        sqlSession = build.openSession();
        mapper = sqlSession.getMapper(IStudentMapper.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void testSelectAllStudent() {
        List<Student> students = mapper.selectAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testStudentService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl studentService = context.getBean("studentService", StudentServiceImpl.class);
        System.out.println(studentService);
        System.out.println(studentService.selectAllStudent());


    }
}

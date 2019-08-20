package com.test.controller;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import com.test.service.IStudentService;
import com.test.service.Impl.StudentServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class TestMain {


    private IStudentMapper mapper;
    private InputStream resourceAsStream;
    private SqlSession sqlSession;


    private TestAnnotation testAnnotation;

    @Autowired
    private StudentServiceImpl studentService;

    public void init() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        sqlSession = build.openSession();
        mapper = sqlSession.getMapper(IStudentMapper.class);
    }


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
//        StudentServiceImpl studentService = context.getBean("studentService", StudentServiceImpl.class);
        SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        List<Student> students = mapper.selectAllStudent();
        System.out.println(students);

    }

    @Test
    public void testDruidConnetion() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    @Test
    public void testDruidConnetion1() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl dataSource = (StudentServiceImpl) context.getBean("studentService");
        System.out.println(dataSource.getStudentMapper().selectAllStudent());
    }

    @Test
    public void testInsertStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (StudentServiceImpl) context.getBean("studentService");
        Student student = new Student();
        student.setName("香风智乃");
        int i =  studentService.InsertStudent(student);
        System.out.println(i);
    }

    @Test
    public void testUpdateStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl dataSource = (StudentServiceImpl) context.getBean("studentService");
        Student student = new Student();
        student.setAddress("Rabbit House");
        student.setName("保登心爱");
        int i = dataSource.updateStudent(student);
        System.out.println(i);
    }

    @Test
    public void testDeleteStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl dataSource = (StudentServiceImpl) context.getBean("studentService");
        Student student = new Student();
        student.setName("保登心爱");
        int i = dataSource.deleteStudent(student);
        System.out.println(i);
    }

    @Test
    public void testAnnotationInsert() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestAnnotation dataSource = (TestAnnotation) context.getBean("testAnnotation");
        dataSource.testSelectStudent();

        testAnnotation.testSelectStudent();

    }

}

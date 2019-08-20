package com.test.controller;

import com.test.configuration.SpringConfiguration;
import com.test.domain.Student;
import com.test.service.IStudentService;
import com.test.service.Impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@PropertySource("classpath:Jdbc.properties")
public class TestAnnotation {
    @Resource(name = "studentService01")
    private IStudentService studentService;

    @Value("${DriverClass}")
    private String DriverClass;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;


    public void testSelectStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("studentService");
        System.out.println(studentService.selectAllStudent());
    }

    @Test
    public void testAnnotationValue() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        StudentServiceImpl dataSource = (StudentServiceImpl) context.getBean("studentService01");
//        System.out.println(studentService.selectAllStudent());


//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (String a : beanDefinitionNames) {
//            System.out.println(a);
//        }

        System.out.println(studentService.selectAllStudent());
    }

    @Test
    public void testValue() {
        System.out.println(DriverClass);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }

}

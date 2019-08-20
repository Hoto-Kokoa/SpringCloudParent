package com.test.controller;

import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import com.test.service.IStudentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//@ComponentScan("com.test.controller")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCommit {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private SqlSession sqlsession1;


    @Test
    public void testApplicationContextBySqlSessionFactory() throws SQLException {

        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        //获取connection对象,设置禁止自动提交
        Connection connection = sqlSession.getConnection();
        connection.setAutoCommit(false);

        //获取代理对象
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);


        try {
            Student student = new Student();
            student.setName("香风智乃");
            int i =  mapper.InsertStudent(student);
            System.out.println(i);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            sqlSession.close();
            connection.close();
        }


    }

    @Test
    public void testApplicationContextBySqlSession() throws SQLException {
        Connection connection = sqlsession1.getConnection();
        connection.setAutoCommit(false);

        //获取代理对象
        IStudentMapper mapper = sqlsession1.getMapper(IStudentMapper.class);


        try {
            Student student = new Student();
            student.setName("香风智乃");
            int i =  mapper.InsertStudent(student);
            System.out.println(i);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            sqlsession1.close();
            connection.close();
        }

    }

}

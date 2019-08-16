package com.test.Test;

import com.test.dao.IStudentDAO;
import com.test.domain.InjectionTest;
import com.test.domain.Staff;
import com.test.domain.Student;
import com.test.service.Impl.StaffService;
import com.test.service.Impl.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMain {
    private InputStream resourceAsStream;
    private SqlSession session;
    private IStudentDAO mapper;


    @Before
    public void init() throws IOException {
        //读取配置文件
        resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //构建者模式:创建构建者对象sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //使用构建者创建工厂对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        //使用工厂对象生产sqlSession对象
        session = build.openSession(true);

        mapper = session.getMapper(IStudentDAO.class);
    }

    public void destory() throws IOException {
        resourceAsStream.close();
        session.close();
    }

    @Test
    public void testSelectAllStudent() {
        List<Student> students = mapper.findAllStudent();
        for (Student student : students)
        {
            System.out.println(student);
        }
    }

    @Test
    public void testSpringStudentGetString()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = (SqlSession) context.getBean("sqlSession");
        IStudentDAO studentDAO = sqlSession.getMapper(IStudentDAO.class);
        List<Student> allStudent = studentDAO.findAllStudent();
        for (Student student : allStudent)
        {
            System.out.println(student);
        }
    }

    @Test
    public void testInjectionTest()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        InjectionTest injectionTest = (InjectionTest) context.getBean("injectionTest");
        System.out.println(injectionTest);
    }

    @Test
    public void testStaffSelect() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StaffService injectionTest = (StaffService) context.getBean("staffService");
        List<Staff> list = injectionTest.selectAllStaff();
        System.out.println(list);
    }

    @Test
    public void testStaffUpdate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StaffService injectionTest = (StaffService) context.getBean("staffService");
        Staff staff = new Staff();
        staff.setName("保登心爱");
        staff.setHouse("Rabbit House");
        int  i  = injectionTest.UpdateStaff(staff);
        System.out.println(i);
    }
    @Test
    public void testStaffInsert() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StaffService injectionTest = (StaffService) context.getBean("staffService");
        Staff staff = new Staff();
        staff.setName("保登心爱");
        staff.setHouse("Rabbit House");
        int  i  = injectionTest.InsertStaff(staff);
        System.out.println(i);
    }
    @Test
    public void testStaffDelete() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StaffService injectionTest = (StaffService) context.getBean("staffService");
        Staff staff = new Staff();
        staff.setName("保登心爱");
        staff.setHouse("Rabbit House");
        int  i  = injectionTest.DeleteStaff(staff);
        System.out.println(i);
    }

}

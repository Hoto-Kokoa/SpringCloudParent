package com.test.test;

import com.test.dao.Impl.EmployeeDAOImpl;
import com.test.domain.Employee;
import com.test.service.IEmployeeService;
import com.test.service.Impl.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMain {


    @Autowired
    private IEmployeeService service;
    //代理对象
    @Test
    public void TestSave() {
        System.out.println(service.getClass());
        service.save(new Employee());
    }

    @Test
    public void TestUpdate() {

        service.update(new Employee());
    }

}

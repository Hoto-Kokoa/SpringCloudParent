package com.test.test;

import com.test.domain.Employee;
import com.test.service.Impl.EmployeeServiceImpl;
import com.test.tx.TransactionManagerAdvance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMain {



    @Autowired
    private TransactionManagerAdvance advance;


    //代理对象
    @Test
    public void TestSave() {
        EmployeeServiceImpl employeeService = advance.getProxyObject();
        employeeService.save(new Employee());
    }

    @Test
    public void TestUpdate() {

    }



}

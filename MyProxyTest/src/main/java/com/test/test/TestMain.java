package com.test.test;

import com.test.domain.Employee;
import com.test.service.IEmployeeService;
import com.test.tx.TransactionManagerAdvance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMain {

    @Autowired
    private IEmployeeService service;

    @Autowired
    private TransactionManagerAdvance advance;


    //代理对象
    @Test
    public void TestSave() {
//        先获取代理对象
        IEmployeeService proxy = advance.getProxyObject();
        proxy.save(new Employee());
    }

    @Test
    public void TestUpdate() {
        //        先获取代理对象
        IEmployeeService proxy = advance.getProxyObject();
        proxy.update(new Employee());
    }



}

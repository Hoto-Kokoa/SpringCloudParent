package com.test.Test;


import com.test.service.Impl.LoginServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestByAnnotate {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @Test
    public void testLogin() {
        int i = loginServiceImpl.login("保登心爱", "123");
        System.out.println(i);
    }
}

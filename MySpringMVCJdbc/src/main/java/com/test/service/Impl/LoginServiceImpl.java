package com.test.service.Impl;

import com.test.dao.IloginDAO;
import com.test.service.IloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements IloginService {

    @Autowired
    private IloginDAO iloginDAO;

    public int login(String username, String password) {
        System.out.println(iloginDAO.login(username, password));
        return iloginDAO.login(username, password);
    }
}

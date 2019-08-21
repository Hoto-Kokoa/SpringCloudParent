package com.test.service.Impl;

import com.test.dao.IEmployeeDAO;
import com.test.domain.Employee;
import lombok.Setter;


@Setter
public class EmployeeServiceImpl{

    private IEmployeeDAO dao;

    public void save(Employee emp) {
        dao.save(emp);
        System.out.println("保存成功");
    }

    public void update(Employee emp) {
        dao.update(emp);
        throw new RuntimeException("故意出错");
    }
}

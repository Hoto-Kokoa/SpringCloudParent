package com.test.service.Impl;

import com.test.dao.IEmployeeDAO;
import com.test.domain.Employee;
import com.test.service.IEmployeeService;
import lombok.Setter;


@Setter
public class EmployeeServiceImpl implements IEmployeeService {

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

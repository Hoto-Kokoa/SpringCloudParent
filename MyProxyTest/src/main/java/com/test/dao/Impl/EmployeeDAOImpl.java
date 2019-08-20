package com.test.dao.Impl;

import com.test.dao.IEmployeeDAO;
import com.test.domain.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {

    public void save(Employee emp) {
        System.out.println("保存员工");
    }

    public void update(Employee employee) {
        System.out.println("修改员工");
    }
}

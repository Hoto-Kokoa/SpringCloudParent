package com.test.dao;

import com.test.domain.Employee;

public interface IEmployeeDAO {
    void save(Employee emp);

    void update(Employee employee);
}

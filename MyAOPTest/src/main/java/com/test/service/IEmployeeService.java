package com.test.service;

import com.test.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    void save(Employee emp);


    void update(Employee emp);

    List<Employee> selectAll();
}

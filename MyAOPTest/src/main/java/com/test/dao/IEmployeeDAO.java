package com.test.dao;

import com.test.domain.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IEmployeeDAO {
    void save(Employee emp);

    void update(Employee employee);

    @Select("select * from student")
    List<Employee> selectAll();
}

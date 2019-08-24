package com.test.dao;

import com.test.domain.Employee;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IEmployeeDAO {
    void save(Employee emp);

    @Update("update student set sex= '女' where name = '芙兰朵露'")
    void update(Employee employee);

    @Select("select * from student")
    List<Employee> selectAll();
}

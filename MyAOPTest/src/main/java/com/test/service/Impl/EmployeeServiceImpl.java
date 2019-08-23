package com.test.service.Impl;

import com.test.dao.IEmployeeDAO;
import com.test.domain.Employee;
import com.test.service.IEmployeeService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Setter
@Getter
@ToString
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO dao;

    public void save(Employee emp) {
        System.out.println("IEmployeeDAO  emp:------------------------------->" + emp);
        System.out.println("EmployeeServiceImpl  dao:------------------------------->" + dao);
        dao.save(emp);
        System.out.println("保存成功");
    }

    public void update(Employee emp) {
        dao.update(emp);
        throw new RuntimeException("故意出错");
    }

    public List<Employee> selectAll() {
        return dao.selectAll();
    }

    public void testProxy() {
        System.out.println("success!!!!!!!!!!");
    }
}

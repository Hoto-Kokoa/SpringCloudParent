package com.test.service.Impl;

import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl {
    @Autowired
    private IStudentMapper studentMapper;

    public List<Student> selectAllStudent() {

         return studentMapper.selectAllStudent();
    }
}

package com.test.service.Impl;

import com.test.domain.Student;
import com.test.mapper.IStudentMapper;

import java.util.List;

public class StudentServiceImpl {

    private IStudentMapper studentMapper;

    public List<Student> selectAllStudent() {

         return studentMapper.selectAllStudent();
    }
}

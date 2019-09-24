package com.example.demo.service.impl;

import com.example.demo.domain.Student;
import com.example.demo.mapper.IStudentMapper;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return  studentMapper.findAll();
    }
}

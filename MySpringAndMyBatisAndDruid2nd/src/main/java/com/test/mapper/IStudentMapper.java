package com.test.mapper;

import com.test.domain.Student;

import java.util.List;

public interface IStudentMapper {
    List<Student> selectAllStudent();
}

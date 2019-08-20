package com.test.mapper;

import com.test.domain.Student;

import java.util.List;

public interface IStudentMapper {
    List<Student> selectAllStudent();

    int InsertStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(Student student);
}

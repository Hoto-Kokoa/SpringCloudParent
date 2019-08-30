package com.test.service;

import com.test.domain.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAllStudent();

    Student selectStudentById(Integer id);

    Integer deleteStudent(Integer id);

    Integer insertStudnent(Student student);

    Integer updateStudent(Student student);
}

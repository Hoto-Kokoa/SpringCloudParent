package com.test.service;

import com.test.domain.Student;

import java.util.List;

public interface IStudentService {

    List<Student> selectAllStudent();

    int InsertStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(Student student);
}

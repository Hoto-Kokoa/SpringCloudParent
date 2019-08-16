package com.test.dao;

import com.test.domain.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> findAllStudent();
}

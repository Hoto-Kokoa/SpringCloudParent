package com.test.service.Impl;

import com.test.dao.IStudentDAO;
import com.test.domain.Student;
import com.test.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    public List<Student> findAllStudent()
    {
         return studentDAO.findAllStudent();
    }
}

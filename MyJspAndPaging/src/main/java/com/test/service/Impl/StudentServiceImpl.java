package com.test.service.Impl;

import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import com.test.service.IStudentService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StudentServiceImpl implements IStudentService {
    private IStudentMapper studentMapper;

    public List<Student> selectAllStudent() {
        return studentMapper.selectAllStudent();
    }

    public Student selectStudentById(Integer id){
        return studentMapper.selectStudentById(id);
    }

    public Integer deleteStudent(Integer id) {
        return studentMapper.deleteStudent(id);
    }

    public Integer insertStudnent(Student student) {
        return studentMapper.insertStudnent(student);
    }
}

package com.test.service.Impl;

import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StudentServiceImpl implements IStudentMapper {
    private IStudentMapper studentMapper;

    public List<Student> selectAllStudent() {
        return studentMapper.selectAllStudent();
    }
}

package com.test.service.Impl;

import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import com.test.service.IStudentService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class StudentServiceImpl implements IStudentService {
//    @Autowired
    private IStudentMapper studentMapper;

    public List<Student> selectAllStudent() {

        return studentMapper.selectAllStudent();
    }

    public int InsertStudent(Student student) {
        return studentMapper.InsertStudent(student);
    }

    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public int deleteStudent(Student student) {
        return studentMapper.deleteStudent(student);
    }
}

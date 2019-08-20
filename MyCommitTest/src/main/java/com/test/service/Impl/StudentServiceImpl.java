package com.test.service.Impl;

import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import com.test.service.IStudentService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Setter
@Getter
@ToString
@Component("studentService01")

public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentMapper studentMapper;

    @PostConstruct
    public void initMethod(){
        System.out.println("初始化方法");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("销毁方法");
    }

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

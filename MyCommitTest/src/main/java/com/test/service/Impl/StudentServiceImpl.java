package com.test.service.Impl;

import com.test.domain.Student;
import com.test.mapper.IStudentMapper;
import com.test.service.IStudentService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.rules.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

import static java.lang.Thread.sleep;

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

    @Transactional(timeout = 5)
    public List<Student> selectAllStudent() {
        try {
            sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

package com.test.mapper;

import com.test.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentMapper {
    @Select("select * from student")
    List<Student> selectAllStudent();
}

package com.example.demo.mapper;

import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IStudentMapper {
    @Select("select * from student")
    List<Student> findAll();
}

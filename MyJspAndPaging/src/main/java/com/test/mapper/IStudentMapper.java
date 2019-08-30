package com.test.mapper;

import com.test.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IStudentMapper {
    @Select("select * from student")
    List<Student> selectAllStudent();

    @Select("select * from student where id = #{id}")
    Student selectStudentById(Integer id);

    @Delete("delete from student where id = #{id}")
   Integer deleteStudent(Integer id);

    @Insert("insert student values(default,#{name},#{sex},#{address},#{department})")
    Integer insertStudnent(Student student);

    @Update("update student set id = #{id},name = #{name}, sex = #{sex}, address = #{address} where id =#{id}")
    Integer updateStudent(Student student);
}

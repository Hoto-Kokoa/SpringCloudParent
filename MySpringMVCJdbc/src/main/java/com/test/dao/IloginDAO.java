package com.test.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IloginDAO {
    @Select("select count(*) from users where username = #{username} and password = #{password}")
    int login(@Param("username") String username, @Param("password")String password);
}

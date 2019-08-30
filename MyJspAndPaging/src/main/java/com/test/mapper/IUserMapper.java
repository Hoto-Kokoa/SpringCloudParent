package com.test.mapper;

import com.test.domain.Users;
import org.apache.ibatis.annotations.Select;

public interface IUserMapper {
    @Select("select * from users where username = #{username} and password = #{password}")
    Users login(Users users);
}

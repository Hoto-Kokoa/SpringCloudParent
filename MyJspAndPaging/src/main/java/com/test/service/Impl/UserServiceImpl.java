package com.test.service.Impl;

import com.test.service.IUserService;
import com.test.domain.Users;
import com.test.mapper.IUserMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserServiceImpl implements IUserService {

    private IUserMapper userMapper;

    public Users login(Users users) {
        return userMapper.login(users);
    }
}

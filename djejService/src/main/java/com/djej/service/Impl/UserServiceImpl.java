package com.djej.service.Impl;

import com.djej.domain.User;
import com.djej.mapper.UserMapper;
import com.djej.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public String test2() {
        return "test2";
    }

    public User selectByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

package com.gwy.service.impl;

import com.gwy.dao.UserMapper;
import com.gwy.model.User;
import com.gwy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByName(User user) {
        return userMapper.getUserByName(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User getUserByNamePass(User user) {
        return userMapper.getUserByNamePass(user);
    }
}

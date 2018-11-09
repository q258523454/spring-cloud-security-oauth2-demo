package com.springBootTest.service.impl;

import com.springBootTest.dao.UserMapper;
import com.springBootTest.entity.User;
import com.springBootTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-11-05
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }
}

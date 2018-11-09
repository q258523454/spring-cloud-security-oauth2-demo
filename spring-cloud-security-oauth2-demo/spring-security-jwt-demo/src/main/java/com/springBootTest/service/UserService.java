package com.springBootTest.service;


import com.springBootTest.entity.User;

import java.util.List;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-11-05
 */
public interface UserService {
    public Integer insertUser(User user);

    public List<User> findAll();

    public User findByUserName(String username);

}

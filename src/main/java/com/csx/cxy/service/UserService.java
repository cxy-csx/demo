package com.csx.cxy.service;


import com.csx.cxy.entity.User;
import com.csx.cxy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(Integer userId) {

        int x = 1 /0;


        return userMapper.getUserInfo(userId);

    }
}

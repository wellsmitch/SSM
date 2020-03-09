package com.song.service;

import com.song.mapper.UserMapper;
import com.song.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    UserMapper userMapper;
    public List<User> findUserByUser(User user) {
        return userMapper.findUserByUser(user);
    }

    public String insertUserByUser(User user) {
        userMapper.insertUser(user);
        return "SUCCESS";
    }
    public List<User> findAllUserImp() {
        List<User> allUser = userMapper.findAllUser();
        return allUser;
    }
}

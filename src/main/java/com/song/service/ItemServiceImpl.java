package com.song.service;


import com.song.mapper.UserMapper;
import com.song.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private UserMapper userMapper;

	public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

	public List<User> findUserByUser(User user) {
        return userMapper.findUserByUser(user);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public List<User> getUser(Integer id) {
        return userMapper.findUserById(id);
    }
}

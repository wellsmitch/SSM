package com.song.mapper;



import com.song.pojo.User;

import java.util.List;


public interface UserMapper {
	public List<User> findUserById(Integer id);
	public void insertUser(User user);
}

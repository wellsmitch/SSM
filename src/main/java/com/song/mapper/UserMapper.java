package com.song.mapper;



import com.song.pojo.User;

import java.util.List;


public interface UserMapper {
    List<User> findAllUser();
    List<User> findUserByUser(User user);
	List<User> findUserById(Integer id);
	void insertUser(User user);
}

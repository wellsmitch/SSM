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
	//��ѯ��Ʒ��Ʒ
	public List<User> selectUser() {
		return userMapper.findUserById(3);
	}
}

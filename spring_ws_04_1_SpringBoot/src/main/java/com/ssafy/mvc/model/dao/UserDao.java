package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {
	
	boolean insertUser(User user);
	
	User login(User user);
	
	List<User> selectAll();
	
	User selectOne(String id);
}

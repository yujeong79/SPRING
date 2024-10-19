package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.User;

public interface UserService {
	
	boolean insertUser(User user);
	
	User login(User user);
	
	List<User> selectAll();
	
	User selectOne(String id);
}

package com.ssafy.mvc.model.dao;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {
	
	User selectById(String id);
	
}

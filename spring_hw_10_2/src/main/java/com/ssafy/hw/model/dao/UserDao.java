package com.ssafy.hw.model.dao;

import java.util.List;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

public interface UserDao {
	
	List<User> selectAll();
	
	int insert(User user);
	
	User selectById(String id);
	
	List<User> selectByCondition(SearchCondition condition);
	
}

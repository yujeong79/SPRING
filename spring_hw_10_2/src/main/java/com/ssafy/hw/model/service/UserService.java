package com.ssafy.hw.model.service;

import java.util.List;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

public interface UserService {
	
	List<User> selectAll();
	
	boolean regist(User user);
	
	User searchById(String id);
	
	List<User> searchByCondition(SearchCondition condition);
	
}

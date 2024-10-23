package com.ssafy.mvc.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {
	public List<User> selectAll();

	public int insertUser(User user);

	public User selectOne(Map<String, String> info);
}
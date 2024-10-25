package com.ssafy.mvc.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	
	// @Autowired 생략
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public boolean signup(User user) {
		int cnt = userDao.insertUser(user);
		return cnt > 0;
	}

	@Override
	public User login(String id, String password) {
		Map<String, String> info = new HashMap<>(); // Dao에 Map을 넘겨보자
		info.put("id", id);
		info.put("password", password);
		
		User loginUser = userDao.selectOne(info);
		
		return loginUser;
	}
	
	

}

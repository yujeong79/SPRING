package com.ssafy.ws.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao dao;
	
	// 자동 @Autowired
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}
	
}

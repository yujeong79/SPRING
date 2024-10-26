package com.ssafy.mvc.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao dao;
	
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}
	
	@Override
	public User searchById(String id) {
		return dao.selectById(id);
	}

}

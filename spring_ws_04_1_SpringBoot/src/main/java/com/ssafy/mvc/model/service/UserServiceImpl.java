package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dao.UserDaoImpl;
import com.ssafy.mvc.model.dto.User;

public class UserServiceImpl implements UserService {
	
	private static UserDao dao = UserDaoImpl.getInstance();
	
	// 싱글턴 /////////////////////////////////////////////////////////
	
	private UserServiceImpl() {}
	
	private static UserService instance = new UserServiceImpl();
	
	public static UserService getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////////////////////////

	@Override
	public boolean insertUser(User user) {
		return dao.insertUser(user);
	}

	@Override
	public User login(User user) {
		return dao.login(user);
	}

	@Override
	public List<User> selectAll() {
		return dao.selectAll();
	}

	@Override
	public User selectOne(String id) {
		return dao.selectOne(id);
	}
	
}

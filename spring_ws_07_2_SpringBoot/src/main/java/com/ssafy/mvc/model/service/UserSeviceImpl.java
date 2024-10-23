package com.ssafy.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserSeviceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public boolean regist(User user) {
		return dao.insert(user) > 0;
	}

}

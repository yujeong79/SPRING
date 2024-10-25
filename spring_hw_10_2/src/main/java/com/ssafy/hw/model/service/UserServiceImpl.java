package com.ssafy.hw.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao dao;
	
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public List<User> selectAll() {
		return dao.selectAll();
	}

	@Override
	public boolean regist(User user) {
		return dao.insert(user) > 0;
	}

	@Override
	public User searchById(String id) {
		return dao.selectById(id);
	}

	@Override
	public List<User> searchByCondition(SearchCondition condition) {
		return dao.selectByCondition(condition);
	}

}

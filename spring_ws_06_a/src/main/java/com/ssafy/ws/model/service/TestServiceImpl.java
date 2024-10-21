package com.ssafy.ws.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.TestDao;
import com.ssafy.ws.model.dto.DateDto;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;
	
	@Override
	public DateDto test() throws Exception {
		return testDao.getCurrentDate();
	}
}

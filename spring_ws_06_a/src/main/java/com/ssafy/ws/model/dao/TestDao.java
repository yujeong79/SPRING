package com.ssafy.ws.model.dao;

import com.ssafy.ws.model.dto.DateDto;

public interface TestDao {
	public DateDto getCurrentDate() throws Exception;
}

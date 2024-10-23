package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Movie;

public interface MovieDao {
	
	int insert(Movie movie);
	
	List<Movie> selectAll();
	
	Movie selectById(int id);
	
	int update(Movie movie);
	
	int delete(int id);
	
}

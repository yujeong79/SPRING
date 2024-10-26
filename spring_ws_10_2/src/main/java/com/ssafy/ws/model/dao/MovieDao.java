package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;

public interface MovieDao {
	
	List<Movie> selectAll();
	
	int insert(Movie movie);
	
	int delete(int id);
	
	List<Movie> selectByTitle(String title);
	
	Movie selectById(int id);
}

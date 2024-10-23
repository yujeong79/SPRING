package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Movie;

public interface MovieService {
	
	boolean insert(Movie movie);
	
	List<Movie> selectAll();
	
	Movie selectById(int id);
	
	boolean update(Movie movie);
	
	boolean delete(int id);
	
}

package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;

public interface MovieService {
	
	void insertMovie(Movie movie);
	
	Movie searchById(int id);
	
	List<Movie> selectAll();
	
	List<Movie> searchByTitle(String title);
}

package com.ssafy.ws.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

public interface MovieService {
	
	List<Movie> getList();
	
	boolean regist(Movie movie);
	
	boolean remove(int id);
	
	List<Movie> searchByTitle(String title);
	
	Movie searchById(int id);

}

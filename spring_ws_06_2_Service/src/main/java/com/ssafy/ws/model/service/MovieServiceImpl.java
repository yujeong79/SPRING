package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	private final MovieDao dao;
	
	// 자동 @Autowired
	public MovieServiceImpl(MovieDao dao) {
		this.dao = dao;
	}

	@Override
	public void insertMovie(Movie movie) {
		dao.insert(movie);
	}

	@Override
	public Movie searchById(int id) {
		return dao.searchById(id);
	}

	@Override
	public List<Movie> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Movie> searchByTitle(String title) {
		return dao.searchByTitle(title);
	}
	
	
}

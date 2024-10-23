package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.MovieDao;
import com.ssafy.mvc.model.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	private final MovieDao dao;
	
	public MovieServiceImpl(MovieDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean insert(Movie movie) {
		int cnt = dao.insert(movie);
		return cnt > 0;
	}

	@Override
	public List<Movie> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Movie selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	public boolean update(Movie movie) {
		return dao.update(movie) > 0;
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id) > 0;
	}

}

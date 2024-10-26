package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

// bean으로 등록 할수 있도록 Service를 선언한다.
@Service
public class MovieServiceImpl implements MovieService {

	private MovieDao dao;
	
	public MovieServiceImpl(MovieDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Movie> getList() {
		return dao.selectAll();
	}

	@Override
	public boolean regist(Movie movie) {
		return dao.insert(movie) > 0;
	}

	@Override
	public boolean remove(int id) {
		return dao.delete(id) > 0;
	}

	@Override
	public List<Movie> searchByTitle(String title) {
		return dao.selectByTitle(title);
	}

	@Override
	public Movie searchById(int id) {
		return dao.selectById(id);
	}
	
	
}

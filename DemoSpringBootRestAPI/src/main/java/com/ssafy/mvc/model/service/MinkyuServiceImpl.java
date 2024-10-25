package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.MinkyuDao;
import com.ssafy.mvc.model.dto.Minkyu;

@Service
public class MinkyuServiceImpl implements MinkyuService {

	private MinkyuDao dao;
	
	public MinkyuServiceImpl(MinkyuDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public boolean registMinkyu(Minkyu minkyu) {
		return dao.insertMinkyu(minkyu) > 0;
	}

	@Override
	public List<Minkyu> getMinkyuList() {
		return dao.selectAll();
	}

	@Override
	public Minkyu getMinkyu(int id) {
		return dao.selectOne(id);
	}

	@Transactional
	@Override
	public boolean changeMinkyu(Minkyu minkyu) {
		return dao.updateMinkyu(minkyu) > 0;
	}

	@Transactional
	@Override
	public boolean removeMinkyu(int id) {
		return dao.deleteMinkyu(id) > 0;
	}
}

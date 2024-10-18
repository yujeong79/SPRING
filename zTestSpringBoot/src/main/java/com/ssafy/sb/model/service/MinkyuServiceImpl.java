package com.ssafy.sb.model.service;

import java.util.List;

import com.ssafy.sb.model.dao.MinkyuDao;
import com.ssafy.sb.model.dao.MinkyuDaoImpl;
import com.ssafy.sb.model.dto.Minkyu;
import com.ssafy.sb.util.DBUtil;

public class MinkyuServiceImpl implements MinkyuService {

	private MinkyuDao dao;
	
	// 싱글턴 /////////////////////////////////////////////////////////////////
	private static MinkyuService instance = new MinkyuServiceImpl();
	private MinkyuServiceImpl() {
		dao = MinkyuDaoImpl.getInstance();
	}
	
	public static MinkyuService getInstance() { // 객체 생성 없이 접근 하기 위해서 static
		return instance;
	}
	/////////////////////////////////////////////////////////////////////////

	@Override
	public void registMinkyu(Minkyu minkyu) {
		dao.InsertMinkyu(minkyu);
	}

	@Override
	public List<Minkyu> getMinkyuList() {
		return dao.selectAll();
	}

	@Override
	public Minkyu getMinkyu(int id) {
		return dao.selectOne(id);
	}

	@Override
	public void changeMinkyu(Minkyu minkyu) {
		dao.updateMinkyu(minkyu);
	}

	@Override
	public void removeMinkyu(int id) {
		dao.deleteMinkyu(id);
	}
}

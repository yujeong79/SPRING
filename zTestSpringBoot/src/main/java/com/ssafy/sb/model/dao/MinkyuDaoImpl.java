package com.ssafy.sb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ssafy.sb.model.dto.Minkyu;
import com.ssafy.sb.util.DBUtil;

public class MinkyuDaoImpl implements MinkyuDao {
	// DB가 없어서 id를 저장하기 위해 임시로 사용
	private Map<Integer, Minkyu> minkyus;
	private static int listIndex; // AUTO_INCREMENT 동작 대신
	
	// 싱글턴 ////////////////////////////////////////////////////////////////////////////
	// 느슨한 결합을 위해 인터페이스로 받기
	private static MinkyuDao instance = new MinkyuDaoImpl();
	private MinkyuDaoImpl() {
		// DB 대신 사용하기 위해 가짜 데이터를 몇 개 넣자
		minkyus = new HashMap<Integer, Minkyu>();
		minkyus.put(listIndex++, new Minkyu(0, "김싸피", "ssafyKim@ssafy.com"));
		minkyus.put(listIndex++, new Minkyu(1, "이싸피", "ssafyLee@ssafy.com"));
		minkyus.put(listIndex++, new Minkyu(2, "박싸피", "ssafyPark@ssafy.com"));
		minkyus.put(listIndex++, new Minkyu(3, "최싸피", "ssafyChoi@ssafy.com"));
	}
	
	public static MinkyuDao getInstance() { // 객체 생성 없이 접근 하기 위해서 static
		return instance;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void InsertMinkyu(Minkyu minkyu) {
		minkyu.setUserid(listIndex);
		
		minkyus.put(listIndex++, minkyu);
	}

	@Override
	public List<Minkyu> selectAll() {
		List<Minkyu> list = new ArrayList<>();
		
		for(Integer key : minkyus.keySet()) {
			list.add(minkyus.get(key));
		}
		
		return list;
	}

	@Override
	public Minkyu selectOne(int id) {
		return minkyus.get(id);
	}

	@Override
	public void updateMinkyu(Minkyu minkyu) {
		int id = minkyu.getUserid();
		
		for(Integer key : minkyus.keySet()) {
			if(key == id) {
				minkyus.get(key).setName(minkyu.getName());
				minkyus.get(key).setEmail(minkyu.getEmail());
				return;
			}
		}
	}

	@Override
	public void deleteMinkyu(int id) {
		for(Integer key : minkyus.keySet()) {
			if(key == id) {
				minkyus.remove(key);
				return;
			}
		}
	}
}

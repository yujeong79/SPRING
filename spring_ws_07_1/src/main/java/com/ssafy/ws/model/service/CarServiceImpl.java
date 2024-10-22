package com.ssafy.ws.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.CarDao;
import com.ssafy.ws.model.dto.Car;

@Service
public class CarServiceImpl implements CarService {

	private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

	/**
	 * has a 관계로 사용할 CarDao 타입의 carDao를 선언한다.
	 */
	private CarDao carDao;
	/**
	 * 파일 업로드 경로를 설정하기 위해 ResourceLoader를 주입받는다.
	 */
	@Autowired
	ResourceLoader resLoader;

	/**
	 * setter를 통해 CarDao를 주입받는다.
	 * 
	 * @Autowired를 통해 CarDao 타입의 빈을 주입 받는다.
	 * @param carDao
	 */
	@Autowired
	public void setRepo(CarDao dao) {
		this.carDao = dao;
	}

	@Override
	// 트랜잭션 처리를 위해 어노테이션 설정
	@Transactional
	public int insert(Car car) {
//		// 에러 발생 코드
//		car.setVin("error");
		carDao.insert(car);
		return carDao.insert(car);
	}

	@Override
	public Car searchByVin(String vin) {
		return carDao.searchByVin(vin);
	}

	@Override
	public List<Car> selectAll() {
		return carDao.selectAll();
	}

	@Override
	public List<Car> searchByModelName(String modelName) {
		return carDao.searchByModelName(modelName);
	}

}

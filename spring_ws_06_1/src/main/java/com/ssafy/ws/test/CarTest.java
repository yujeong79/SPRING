package com.ssafy.ws.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.ws.model.dao.CarDao;
import com.ssafy.ws.model.dto.Car;


public class CarTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		//코드작성
		SqlSessionFactory sessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
		
		try(SqlSession session = sessionFactory.openSession()) {
			
			CarDao carDao = session.getMapper(CarDao.class);
			Car car = carDao.searchByVin("KNHXX00XXXX000001");
			
			System.out.println(car);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.ssafy.hw.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.User;

public class UserTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
		
		// 사용자 등록
//		try(SqlSession sqlSession = sqlSessionFactory.openSession(true);) {
//			UserDao dao = sqlSession.getMapper(UserDao.class);
//			
//			User newUser = new User("hellokitty", "1234", "헬로키티", "hellokitty@ssafy.com", 5);
//			System.out.println(dao.insert(newUser));
//		}
		
		// 아이디로 사용자 조회 
//		try(SqlSession sqlSession = sqlSessionFactory.openSession(true);) {
//			UserDao dao = sqlSession.getMapper(UserDao.class);
//			
//			User user = dao.searchById("ssafy");
//			System.out.println(user);
//		}
		
		// 전체 사용자 목록 조회
//		try(SqlSession sqlSession = sqlSessionFactory.openSession(true);) {
//			UserDao dao = sqlSession.getMapper(UserDao.class);
//			
//			List<User> users = dao.selectAll();
//			System.out.println(users);
//		}
		
		// 이름으로 사용자 조회
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true);) {
			UserDao dao = sqlSession.getMapper(UserDao.class);
			
			List<User> users = dao.searchByName("키티");
			System.out.println(users);
		}
		
		
		
	}
}

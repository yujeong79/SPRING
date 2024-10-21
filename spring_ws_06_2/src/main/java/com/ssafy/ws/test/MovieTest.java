package com.ssafy.ws.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

public class MovieTest {
	public static void main(String[] args) {
		
		// Spring 컨테이너 객체 빌드하기
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		// Bean으로 등록한 sqlSessionFactory 객체를 가져오기
		SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
		
		// 제목으로 영화를 조회해보자
		
		// SqlSessionFactory의 openSession을 사용해서 sqlSession 객체 생성하기
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true);) {
			MovieDao dao = sqlSession.getMapper(MovieDao.class); // MovieDao 클래스와 Mapper를 가지고 내부적으로 Implements(구현체)를 알아서 만들어서 dao에 넣어준다.
			
			List<Movie> movies = dao.searchByTitle("해리포터");
			System.out.println(movies);
		}
		
	}
}

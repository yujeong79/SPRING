package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 이 코드는 MyBatis 설정 파일(mybatis-config.xml)을 읽어 SqlSessionFactory를 생성하는 역할을 합니다. 
 * 이 공장은 이후 데이터베이스와 상호작용하는 SQL 세션을 만드는 데 사용됩니다.
 */
public class MyBatisConfig {
	// MyBatis는 SqlSession 인터페이스를 통해 DB와 상호작용한다.
	// SqlSession을 사용하기 위해서 SqlsessionFactory를 만들자.
	private static SqlSessionFactory factory;
	static {
		// 공장을 세워야하는데 그 자원(설정파일) 위치
		String resource = "mybatis-config.xml"; // MyBatis 설정 파일을 로드
		try(InputStream inputStream = Resources.getResourceAsStream(resource)) { // mybatis-config.xml 파일을 읽어오고 InputStream 객체를 생성하여 이 설정 파일의 내용을 MyBatis에 제공
			factory = new SqlSessionFactoryBuilder().build(inputStream); // SqlSessionFactory는 SqlSessionFactoryBuilder를 사용해서 만들어주어야 한다, build(inputStream)은 설정 파일을 기반으로 SqlSessionFactory를 구성할 수 있게 한다.
			System.out.println("공장 건설 완료");
		} catch (IOException e) {
			System.out.println("공장 건설 실패");
			e.printStackTrace();
		}
	}
	
	// 공장을 이렇게 세워두고 필요하다면 공장을 통해서 openSession 해서 연다. 
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}

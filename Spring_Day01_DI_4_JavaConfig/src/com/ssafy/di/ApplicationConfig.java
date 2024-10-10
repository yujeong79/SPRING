package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * applicationContext.xml이 필요없는 대신에 설정을 모아놓는 자바 파일이 필요
 */
@Configuration
public class ApplicationConfig {
	
	// 객체가 생성될 때마다 새로 생성되는 것이 아님
	// 싱글턴으로 관리
	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
	
	@Bean
	public Programmer programmer() {
		// 생성자 주입
		Programmer p = new Programmer(desktop());
		return p;
	}

}

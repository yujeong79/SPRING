package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Audience {

	// Audience 객체의 watch를 사용하기 위해서는 movie 객체가 필요
	// Audience는 Movie에 의존한다.
	// 의존성 주입
	@Autowired
	@Qualifier("action")
	Movie movie;
	
	public void watch() {
		System.out.println(movie.getInfo() + "영화를 관람합니다.");
	}
	
}

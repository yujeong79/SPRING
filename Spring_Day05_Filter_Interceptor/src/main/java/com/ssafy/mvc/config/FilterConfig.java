package com.ssafy.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.mvc.filter.MyFilter;

// Java Config 파일임을 알려주는 어노테이션
@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<MyFilter> myFilter() { // 메서드 이름이 빈으로 등록한 필터의 이름이 됨, 곧 변수명 같이
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>(); // MyFilter를 등록할 수 있는 Filter Bean을 만들고
		
		registrationBean.setFilter(new MyFilter()); // Bean에 MyFilter를 담음
		registrationBean.addUrlPatterns("/hello"); // hello 요청이 들어왔을 때 이 필터를 동작
		registrationBean.setOrder(1); // 필터의 순서 지정
		
		return registrationBean;
	}

}

package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.AInterceptor;
import com.ssafy.mvc.interceptor.BInterceptor;
import com.ssafy.mvc.interceptor.CInterceptor;
import com.ssafy.mvc.interceptor.LoginInterceptor;

/**
 * Interceptor를 등록하기 위해서는 WebMvcContigurer를 implements 해야한다.
 * 그리고 addInterceptors 메서드를 이용해서 등록해야한다.
 * 
 * @Component로 빈등록이 된 AInterceptor를 
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	/**
	 * 의존성 주입 (필드 주입, 생성자 주입, 설정자 주입)
	 * 여기서는 간편하게 필드 주입을 해보자!
	 * 
	 * AInterceptor 객체가 필요한데 new를 하지 않아도 @Autowired를 통해 객체가 주입된다.
	 */
	@Autowired
	private AInterceptor aInterceptor;
	
	@Autowired
	private BInterceptor bInterceptor;
	
	@Autowired
	private CInterceptor cInterceptor;
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	/**
	 * hello라는 요청이 들어오면 aInterceptor를 동작시킨다.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(aInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(bInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(cInterceptor).addPathPatterns("/hello");
		registry.addInterceptor(loginInterceptor).addPathPatterns("/regist").excludePathPatterns("/hello");
	}
	
}

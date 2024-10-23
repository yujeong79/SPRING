package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.LoginInterceptor;
import com.ssafy.mvc.interceptor.RegistInterceptor;
import com.ssafy.mvc.interceptor.SignupInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private RegistInterceptor registInterceptor;
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Autowired
	private SignupInterceptor signupInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(registInterceptor).addPathPatterns("/movie/regist");
		registry.addInterceptor(loginInterceptor).addPathPatterns("/user/login");
		registry.addInterceptor(signupInterceptor).addPathPatterns("/user/signup");
	}
}

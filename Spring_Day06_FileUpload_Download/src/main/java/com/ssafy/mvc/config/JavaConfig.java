package com.ssafy.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
public class JavaConfig {
	
	// 같은 이름의 JSP 부터 먼저 찾는 것이 아니라 bean이 있나 먼저 확인한다.
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		
		beanNameViewResolver.setOrder(0);
		return beanNameViewResolver;
	}
}

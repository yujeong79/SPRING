package com.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDay09DynamicQueryTXApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDay09DynamicQueryTXApplication.class, args);
		// 등록된 빈들을 볼 수 있다.
		for (String name : context.getBeanDefinitionNames())
			System.out.println(name);
	}
}
























package com.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDay04HelloBootApplication {

	// 자체적으로 tomcat을 갖고 있어서 여기서부터 시작하면 된다고 main 함수가 있음!
	public static void main(String[] args) {
		SpringApplication.run(SpringDay04HelloBootApplication.class, args);
	}

}

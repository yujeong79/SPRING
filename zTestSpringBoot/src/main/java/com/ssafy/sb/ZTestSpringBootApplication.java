package com.ssafy.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 이 밑의 패키지 모든 대상이 Component의 대상
@SpringBootApplication
public class ZTestSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZTestSpringBootApplication.class, args);
	}

}

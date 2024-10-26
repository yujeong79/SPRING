package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
//mybatis의 매퍼 스캔: <mybatis:scan base-package="com.ssafy.ws.model.dao"/>를 대체한다.
@MapperScan(basePackages = "com.ssafy.ws.model.dao")
public class SpringWs102Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringWs102Application.class, args);
	}

}

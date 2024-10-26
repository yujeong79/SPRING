package com.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "SSAFY 도서관리 API",
			description = "워크샵에서 사용되는 RestApi에 대한 문서를 제공한다."
		)
)
public class SpringWs103Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWs103Application.class, args);
	}

}

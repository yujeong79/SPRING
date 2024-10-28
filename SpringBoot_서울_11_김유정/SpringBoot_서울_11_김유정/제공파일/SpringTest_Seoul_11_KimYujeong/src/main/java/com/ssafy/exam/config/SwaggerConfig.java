package com.ssafy.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration // 스프링 설정 클래스임을 나타냅니다.
public class SwaggerConfig {
	@Bean // 스프링 빈으로 등록합니다.
	public OpenAPI openAPI() {
		return new OpenAPI().components(new Components()) // API 구성 요소를 설정합니다.
				.info(apiInfo()); // API 정보를 설정합니다.
	}

	private Info apiInfo() {
		return new Info().title("병원의사 정보 REST API 문서") // API 제목을 설정합니다.
				.description("<h3>의사 정보를 위한 REST API 문서입니다.</h3>") // API 설명을 설정합니다.
				.version("1.0.0"); // API 버전을 설정합니다.
	}
}

package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ssafy.di"}) // 한 방에 스캔하는 방법
public class ApplicationConfig2 {

}

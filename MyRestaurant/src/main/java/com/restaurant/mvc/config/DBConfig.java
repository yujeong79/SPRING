package com.restaurant.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.restaurant.mvc.model.dao")
public class DBConfig {

}

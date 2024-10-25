package com.ssafy.ws.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ssafy.ws.model.dao")
@Configuration
public class MybatisConfig {

}

package com.example.bootTest.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.bootTest.app.db.dao")
public class AppConfig {
}

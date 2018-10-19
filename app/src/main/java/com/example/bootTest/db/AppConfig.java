package com.example.bootTest.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo4.app.db.dao")
public class AppConfig {
}

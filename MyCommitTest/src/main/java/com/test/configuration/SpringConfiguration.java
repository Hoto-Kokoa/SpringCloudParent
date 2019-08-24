package com.test.configuration;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.test.service")
@MapperScan("com.test.mapper")
@Import(value = {JdbcConfig.class,TransactionConfig.class})
public class SpringConfiguration {
}

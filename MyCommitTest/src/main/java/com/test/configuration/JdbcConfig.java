package com.test.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;
import java.util.ResourceBundle;

@Configuration
@PropertySource("classpath:Jdbc.properties")
public class JdbcConfig {




    @Bean("dataSource")
    public DataSource createDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        ResourceBundle jdbc = ResourceBundle.getBundle("Jdbc");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_01?serverTimezone=Asia/Shanghai&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        return dataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
}

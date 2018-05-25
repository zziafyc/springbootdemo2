package com.zhongyong.springbootdemo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class MybatisConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.zhongyong.springbootdemo2.mapper");
        Properties properties = new Properties();
        properties.setProperty("mappers", "com.zhongyong.springbootdemo2.base.BaseMapper");
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "SQLSERVER");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}

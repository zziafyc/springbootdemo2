package com.zhongyong.springbootdemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 支持事务
@MapperScan(basePackages = "com.zhongyong.springbootdemo2.mapper")
public class Springbootdemo2Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Springbootdemo2Application.class);
	}

	public static  void  main(String[] args){
		SpringApplication.run(Springbootdemo2Application.class,args);
	}
}
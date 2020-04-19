package com.xt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//spring boot整合mybatis时，去哪里扫描mybatis的mapper接口,
//并通过代理生成对应的mapper对象
@MapperScan("com.xt.mapper")
@EnableCaching
public class ErpApp {
	public static void main(String[] args) {
		SpringApplication.run(ErpApp.class, args);
	}
}

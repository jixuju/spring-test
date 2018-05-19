package com.superwind.test5wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Test5WechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test5WechatApplication.class, args);
	}
}

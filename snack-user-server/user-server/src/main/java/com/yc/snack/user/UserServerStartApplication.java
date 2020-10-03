package com.yc.snack.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.yc.snack.user.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class UserServerStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServerStartApplication.class,args);
	}
}

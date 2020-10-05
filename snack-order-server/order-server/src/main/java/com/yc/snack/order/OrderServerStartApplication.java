package com.yc.snack.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.yc.snack.orders.mapper")
//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@EnableFeignClients(basePackages= {"com.yc.snack.product.client"})
@ComponentScan(basePackages="com.yc.snack")
@SpringCloudApplication//包含以上三个注解
@EnableHystrixDashboard//启用仪表盘
public class OrderServerStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderServerStartApplication.class,args);
	}
}

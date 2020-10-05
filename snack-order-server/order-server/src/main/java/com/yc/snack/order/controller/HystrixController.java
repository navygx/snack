package com.yc.snack.order.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@DefaultProperties(defaultFallback="defaultFallback")
public class HystrixController {
	@GetMapping("/list1")
	public String list() {
		RestTemplate restTemplate=new RestTemplate();
		String response=restTemplate.postForObject("http://127.0.0.1:6644/product/listForGno", Arrays.asList("1","2","3"), String.class);
		return response;
	}
	
	@GetMapping("/list2")
	@HystrixCommand
	public String list2() {
		RestTemplate restTemplate=new RestTemplate();
		String response=restTemplate.postForObject("http://127.0.0.1:6644/product/listForGnos", Arrays.asList("1","2","3"), String.class);
		return response;
	}
	
	@GetMapping("/list3")
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name="circuitBreaker.enabled",value="true"),
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")
	})
	public String list3(Integer num) {
		if(num==1) {
			return "success";
		}
		
		RestTemplate restTemplate=new RestTemplate();
		String response=restTemplate.postForObject("http://127.0.0.1:6644/product/listForGno", Arrays.asList("1","2","3"), String.class);
		return response;
	}
	
	public String fallback() {
		return "哎呀，服务器被挤爆了，等一下再来吧...";
	}
	
	public String defaultFallback() {
		return "不好意思，网络开小差了，请求走丢了...";
	}
	
	/*@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/list2")
	public String list2() {
		ServiceInstance serviceInstance=loadBalancerClient.choose("product-server");
		String url=String.format("http://%s%s%s", serviceInstance.getHost(),serviceInstance.getPort(),"/product/listForGno");
		RestTemplate restTemplate=new RestTemplate();
		String response=restTemplate.postForObject(url, Arrays.asList("1","2","3"), String.class);
		return response;
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/list3")
	public String list3() {
		String response=restTemplate.postForObject("http://product-server/product/listForGno", Arrays.asList("1","2","3"), String.class);
		return response;
	}*/
}

package com.examples.spring.boot.cirbreaker;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@RestController
public class SpringCloudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixApplication.class, args);
	}

	@RequestMapping(value = "/products1")
	@HystrixCommand(fallbackMethod = "fallbackProducts", commandProperties = {			
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			})
	public String getProductsWithTimeout() throws InterruptedException {
		System.out.println("Request received - " + new Date());
		String response = new RestTemplate().getForObject("http://localhost:9090/products", String.class);
			
		System.out.println("Response sent - " + new Date());
		return response;
	}

	// 11:57:00 - 11:57:10
	//  	10 requests - 3 consecutive failures or 50% of req failed
	// 		circuit OPEN - for 10 secs
			// 11:57:11 - 11:57:20
			// 5 requests - All failed with fallback response
				// 11:57:21
				// 1 request
					// IF SUCCESS
						// circuit CLOSED
					// ELSE
						// circuit OPEN - for next 10 secs
	@RequestMapping(value = "/products2")
	@HystrixCommand(fallbackMethod = "fallbackProducts", commandProperties = {			
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name ="circuitBreaker.requestVolumeThreshold", value="3"),
			@HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds", value="10000"),
			@HystrixProperty(name ="circuitBreaker.errorThresholdPercentage", value="50"),
			@HystrixProperty(name ="metrics.rollingStats.timeInMilliseconds", value="10000")
			})	
	public String getProductsWithCircuitBreaker() throws InterruptedException {
		System.out.println("Request received - " + new Date());
		String response = new RestTemplate().getForObject("http://localhost:9090/products", String.class);
			
		System.out.println("Response sent - " + new Date());
		return response;
	}	
	
	private String fallbackProducts() {
		return "Server is busy. Please try after sometime.";
	}	
}
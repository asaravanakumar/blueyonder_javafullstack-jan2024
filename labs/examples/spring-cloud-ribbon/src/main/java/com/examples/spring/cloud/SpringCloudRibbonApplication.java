package com.examples.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@RibbonClient(name="scloud-product-service")
public class SpringCloudRibbonApplication implements CommandLineRunner{
	
//	@Autowired
//	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//http://localhost:9090/products
		String response = restTemplate().getForObject("http://scloud-product-service/", String.class);
		System.out.println(response);
		String response1 = restTemplate().getForObject("http://scloud-product-service/products", String.class);
		System.out.println(response1);
	}

}

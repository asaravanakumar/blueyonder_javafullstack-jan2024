package com.examples.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examples.cassandra.model.Stock;
import com.examples.cassandra.service.StockService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	StockService stockService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stock sapStock = new Stock("sap",2020,500);
		stockService.createStock(sapStock);
	}	
}

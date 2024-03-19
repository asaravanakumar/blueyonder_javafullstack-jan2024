package com.examples.cassandra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.examples.cassandra.model.Stock;
import com.examples.cassandra.util.CassandraConnector;

@Repository
public class StockDao {
	
	@Autowired
	CassandraConnector client;
	
	public void createStock(Stock stock) {
		Session session = client.getSession();
		
		String query = "INSERT INTO stocks (ticker, year, value) VALUES ('" + stock.getTicker() + "'," + stock.getYear() + "," + stock.getValue() + ")";
		
		System.out.println(query);
		session.execute(query);
		
		System.out.println("Stock created ");
		
		getStocks();
	}
	
	public void getStocks() {
		Session session = client.getSession();
		String query = "SELECT * FROM stocks";
		System.out.println(query);
		ResultSet rs = session.execute(query);		
		System.out.println(rs.all());
	}	

}

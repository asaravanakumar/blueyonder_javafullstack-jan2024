package com.examples.cassandra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.cassandra.dao.StockDao;
import com.examples.cassandra.model.Stock;

@Service
public class StockService {
	
	@Autowired
	StockDao stockDao;
	
	public void createStock(Stock stock) {
		stockDao.createStock(stock);
	}

}

package com.examples.sboot.cassandra.service;

import com.examples.sboot.cassandra.model.Stock;
import com.examples.sboot.cassandra.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepo;

    @Override
    public String createStock(Stock stock) {
        Stock savedStock = stockRepo.save(stock);
        return savedStock.getTicker();
    }

    @Override
    public Optional<Stock> getStock(String ticker) {
        return stockRepo.findById(ticker);
    }

    @Override
    public Collection<Stock> getAllStocks() {
        return stockRepo.findAll();
    }
}

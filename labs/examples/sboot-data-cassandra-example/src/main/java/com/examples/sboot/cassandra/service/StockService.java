package com.examples.sboot.cassandra.service;

import com.examples.sboot.cassandra.model.Stock;

import java.util.Collection;
import java.util.Optional;

public interface StockService {
    public String createStock(Stock stock);
    public Optional<Stock> getStock(String ticker);

    public Collection<Stock> getAllStocks();
}

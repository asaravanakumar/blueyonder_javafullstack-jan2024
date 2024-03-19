package com.examples.sboot.cassandra.repo;

import com.examples.sboot.cassandra.model.Stock;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface StockRepository extends CassandraRepository<Stock, String> {
}

package com.examples.sboot.cassandra.controller;

import com.examples.sboot.cassandra.model.ResponseMessage;
import com.examples.sboot.cassandra.model.Stock;
import com.examples.sboot.cassandra.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public Collection<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{ticker}")
    public ResponseEntity<Stock> getCategory(@PathVariable(name = "ticker") String ticker) {
        Optional<Stock> stockOp = stockService.getStock(ticker);
        return ResponseEntity.ok(stockOp.orElseThrow());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> createCategory(@RequestBody Stock stock) {
        String ticker = stockService.createStock(stock);
        ResponseMessage response = null;
        if(ticker != null && !ticker.isBlank()) {
            response = new ResponseMessage("Success", "Stock Created Successfully");
            return ResponseEntity.ok().body(response);
        } else {
            response = new ResponseMessage("Failure", "Stock Creation Failed");
            return ResponseEntity.ok().body(response);
        }
    }
}

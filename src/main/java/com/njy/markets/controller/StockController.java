package com.njy.markets.controller;

import com.njy.markets.entity.Stock;
import com.njy.markets.exception.StockNotFoundException;
import com.njy.markets.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/stocks")
@RestController
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public String defaulted() {
        return "hello stocks!";
    }

    @GetMapping("/{symbol}")
    public Stock getStock(@PathVariable String symbol) {
        return stockService.findStockBySymbol(symbol)
                .orElseThrow(() -> new StockNotFoundException(symbol));
    }



}

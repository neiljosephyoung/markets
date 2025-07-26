package com.njy.markets.service;

import com.njy.markets.entity.Stock;
import com.njy.markets.repository.jpa.StockRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

//    private final StockRepo stockRepo;
//
//    public StockServiceImpl(StockRepo stockRepo) {
//        this.stockRepo = stockRepo;
//    }
//
    @Override
    public Optional<Stock> findStockBySymbol(String symbol) {
        //return stockRepo.findBySymbol(symbol);
        return Optional.empty();
    }
}

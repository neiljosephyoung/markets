package com.njy.markets.service;

import com.njy.markets.entity.Stock;

import java.util.Optional;

public interface StockService {

    Optional<Stock> findStockBySymbol(String symbol);

}

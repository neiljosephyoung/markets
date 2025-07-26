package com.njy.markets.service;

import reactor.core.publisher.Mono;

public interface StockDataImportService {

    void fetchAndSaveStocks();

}

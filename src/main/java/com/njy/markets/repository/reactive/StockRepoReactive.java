package com.njy.markets.repository.reactive;

import com.njy.markets.entity.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface StockRepoReactive extends ReactiveCrudRepository<Stock, Long> {
    Mono<Stock> findBySymbol(String symbol);
}
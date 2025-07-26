package com.njy.markets.repository.jpa;


import com.njy.markets.entity.Stock;

import java.util.Optional;

public interface StockRepo{
    //extends JpaRepository<Stock, Long>} {

    Optional<Stock> findBySymbol(String symbol);

}
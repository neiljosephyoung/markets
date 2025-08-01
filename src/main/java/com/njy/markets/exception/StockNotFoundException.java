package com.njy.markets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotFoundException extends RuntimeException {
  public StockNotFoundException(String symbol) {
    super("Stock not found with symbol: " + symbol);
  }
}

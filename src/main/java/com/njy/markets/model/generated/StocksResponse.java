package com.njy.markets.model.generated;

import java.util.List;

import lombok.Data;

@Data
public class StocksResponse {
    private List<StockDto> data;
    private String status;
}
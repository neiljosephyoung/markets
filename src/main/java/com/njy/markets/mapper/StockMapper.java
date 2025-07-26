package com.njy.markets.mapper;

import com.njy.markets.entity.Stock;
import com.njy.markets.model.generated.StockDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMapper {


    @Mapping(source = "figiCode", target = "figiCode")
    @Mapping(source = "cfiCode", target = "cfiCode")
    @Mapping(source = "symbol", target = "symbol")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "micCode", target = "micCode")
    @Mapping(source = "cusip", target = "cusip")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "currency", target = "currency")
    @Mapping(source = "exchange", target = "exchange")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "isin", target = "isin")
    Stock toEntity(StockDto dto);

}

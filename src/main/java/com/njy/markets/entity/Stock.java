package com.njy.markets.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("stocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

    @Id
    private Long id;

    private String symbol;

    private String name;

    private String currency;

    private String exchange;

    private String micCode;

    private String country;

    private String type;

    private String figiCode;

    private String cfiCode;

    private String isin;

    private String cusip;

    @CreatedDate
    private LocalDateTime importDt;
}

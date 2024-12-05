package com.fetch.takeHome.receiptProcessor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {

    private String retailer;
    private List<Item> items;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private BigDecimal total;
}

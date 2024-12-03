package com.fetch.takeHome.receiptProcessor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {

    private String retailName;
    private ArrayList<Item> items;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;

}

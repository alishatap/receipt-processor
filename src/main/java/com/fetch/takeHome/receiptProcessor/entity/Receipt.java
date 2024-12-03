package com.fetch.takeHome.receiptProcessor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {

    private String retailName;
    private ArrayList<Item> items;
    private Date purchaseDate;
    private LocalTime purchaseTime;

}

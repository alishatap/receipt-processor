package com.fetch.takeHome.receiptProcessor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //TODO: find more appropriate id generation framework
    private String id;
    private String retailName;
    private BigDecimal costTotal;
    private int itemTotal;
    private ArrayList<Item> items;
    private Date purchaseDate;
    private LocalTime purchaseTime;

}

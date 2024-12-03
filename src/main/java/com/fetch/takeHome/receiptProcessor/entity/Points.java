package com.fetch.takeHome.receiptProcessor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //TODO: find more appropriate id generation framework
    private String id;
    private int points;
}

package com.fetch.takeHome.receiptProcessor.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "points_by_id")
@JsonFilter("filter")
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int points;
}

package com.fetch.takeHome.receiptProcessor.service;

import com.fetch.takeHome.receiptProcessor.entity.Points;
import com.fetch.takeHome.receiptProcessor.entity.Receipt;

import java.util.Optional;
import java.util.UUID;

public interface PointsService {

    //Save operation
    Points savePoints(Receipt receipt);

    //Get operation
    Optional<Points> fetchPoints(UUID id);

}

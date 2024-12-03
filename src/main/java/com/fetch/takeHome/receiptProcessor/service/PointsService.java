package com.fetch.takeHome.receiptProcessor.service;

import com.fetch.takeHome.receiptProcessor.entity.Points;
import com.fetch.takeHome.receiptProcessor.entity.Receipt;

public interface PointsService {

    //Save operation
    Points savePoints(Receipt receipt);
    Points generatePoints(Receipt receipt);

    //Get operation
    int fetchPoints(String id);

}

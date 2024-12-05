package com.fetch.takeHome.receiptProcessor.service;

import com.fetch.takeHome.receiptProcessor.entity.Item;
import com.fetch.takeHome.receiptProcessor.entity.Points;
import com.fetch.takeHome.receiptProcessor.entity.Receipt;
import com.fetch.takeHome.receiptProcessor.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PointsServiceImpl implements PointsService{

    @Autowired
    private PointsRepository pointsRepository;

    //Save operation
    public Points savePoints(Receipt receipt) {
        Points points = generatePoints(receipt);
        return pointsRepository.save(points);
    }

    private Points generatePoints(Receipt receipt) {
        int points = 0;
        points += getAlphaNumericPoints(receipt.getRetailer());
        points += getTotalCostPoints(receipt.getTotal());
        points += getItemCountPoints(receipt.getItems());
        points += getItemDescriptionPoints(receipt.getItems());
        points += getDatePoints(receipt.getPurchaseDate());
        points += getTimePoints(receipt.getPurchaseTime());

        Points p = new Points();
        p.setPoints(points);

        return p;
    }

    private int getAlphaNumericPoints(String name) {
        int p = 0;
        for(int i = 0; i < name.length(); i++) {
            if(Character.isLetterOrDigit(name.charAt(i))) p++;
        }
        return p;
    }

    private int getTotalCostPoints(BigDecimal total) {
        int p = 0;

        //round dollar points
        //TODO: see if i can do this without converting to double
        double totalDouble = total.doubleValue();
        if(totalDouble == Math.round(totalDouble)) {
            p += 50;
        }

        //multiple of 0.25 points
        BigDecimal multiple = new BigDecimal("0.25");
        double remainder = total.remainder(multiple).doubleValue();
        if(remainder == 0.0) {
            p += 25;
        }

        return p;

    }

    private int getItemCountPoints(List<Item> items) {
        int itemCount = items.size();
        return (itemCount/2) * 5;
    }

    private int getItemDescriptionPoints(List<Item> items) {
        int p = 0;
        for(Item item : items) {
            String trimmedDescription = item.getShortDescription().trim();
            if(trimmedDescription.length() % 3 == 0) {
                BigDecimal b = item.getPrice().multiply(new BigDecimal("0.2"));
                p += b.setScale(0, RoundingMode.UP).intValue();
            }
        }
        return p;
    }

    private int getDatePoints(LocalDate date) {
        int day = date.getDayOfMonth();
        if(day % 2 != 0) {
            return 6;
        }
        else {
            return 0;
        }
    }

    private int getTimePoints(LocalTime time) {
        if(time.isAfter(LocalTime.of(14, 0)) &&
        time.isBefore(LocalTime.of(16, 0))) {
            return 10;
        }
        else {
            return 0;
        }
    }

    //Fetch operation
    public Optional<Points> fetchPoints(UUID id) {
        return pointsRepository.findById(id);
    }
}

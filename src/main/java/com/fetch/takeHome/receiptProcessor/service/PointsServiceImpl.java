package com.fetch.takeHome.receiptProcessor.service;

import com.fetch.takeHome.receiptProcessor.entity.Item;
import com.fetch.takeHome.receiptProcessor.entity.Points;
import com.fetch.takeHome.receiptProcessor.entity.Receipt;
import com.fetch.takeHome.receiptProcessor.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class PointsServiceImpl implements PointsService{

    @Autowired
    private PointsRepository pointsRepository;

    //Save operation
    public Points savePoints(Receipt receipt) {
        Points points = generatePoints(receipt);
        return pointsRepository.save(points);
    }

    //Generate operation
    public Points generatePoints(Receipt receipt) {
        int points = 0;
        points += getAlphaNumericPoints(receipt.getRetailName());
        points += getTotalCostPoints(receipt.getItems()); //TODO
        points += getItemCountPoints(receipt.getItems()); //TODO
        points += getItemDescriptionPoints(receipt.getItems()); //TODO
        points += getDatePoints(receipt.getPurchaseDate()); //TODO
        points += getTimePoints(receipt.getPurchaseTime()); //TODO

        Points p = new Points();
        p.setPoints(points);

        return p;
    }

    private int getAlphaNumericPoints(String name) {
        int n = 0;
        for(int i = 0; i < name.length(); i++) {
            if(Character.isLetterOrDigit(name.charAt(i))) n++;
        }
        return n;
    }

    private int getTotalCostPoints(ArrayList<Item> items) {
        BigDecimal total = new BigDecimal(0);
        for(Item item : items) {
            total = total.add(item.getPrice());
        }

        //round dollar points

        //multiple of 0.25 points

    }

    private int getItemCountPoints(ArrayList<Item> items) {

    }

    private int getItemDescriptionPoints(ArrayList<Item> items) {

    }

    private int getDatePoints(Date date) {

    }

    private int getTimePoints(LocalTime time) {

    }

    //Fetch operation
    public int fetchPoints(String id) {
        Optional<Points> p = pointsRepository.findById(id);
        return p.get().getPoints(); //TODO: add type checking
    }
}

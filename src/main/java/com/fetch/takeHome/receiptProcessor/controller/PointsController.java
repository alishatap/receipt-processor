package com.fetch.takeHome.receiptProcessor.controller;

import com.fetch.takeHome.receiptProcessor.entity.Points;
import com.fetch.takeHome.receiptProcessor.entity.Receipt;
import com.fetch.takeHome.receiptProcessor.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/receipts")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @PostMapping("/process")
    public Points savePoints (@RequestBody Receipt receipt) {
        return pointsService.savePoints(receipt);
    }

    @GetMapping("/{id}/points")
    public int fetchPoints (@PathVariable("id") String id) {
        return pointsService.fetchPoints(id);
    }

}

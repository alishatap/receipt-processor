package com.fetch.takeHome.receiptProcessor.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fetch.takeHome.receiptProcessor.entity.Points;
import com.fetch.takeHome.receiptProcessor.entity.Receipt;
import com.fetch.takeHome.receiptProcessor.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/receipts")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @PostMapping("/process")
    public MappingJacksonValue savePoints (@RequestBody Receipt receipt) {
        Points p = pointsService.savePoints(receipt);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id");
        FilterProvider filters = new SimpleFilterProvider().addFilter("filter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(p);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/{id}/points")
    public MappingJacksonValue fetchPoints (@PathVariable("id") UUID id) {
        Points p = pointsService.fetchPoints(id).get();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("points");
        FilterProvider filters = new SimpleFilterProvider().addFilter("filter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(p);
        mapping.setFilters(filters);
        return mapping;
    }

}

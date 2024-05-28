package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.repository.model.Brand;
import com.vaika.api.repository.model.Car;
import com.vaika.api.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {
    private final CarService service;

    @GetMapping("/brands/{id}/cars")
    public List<Car> getCarsByBrand(
            @PathVariable String id,
            @RequestParam(required = false) String carType,
            @RequestParam(required = false) String motorType,
            @RequestParam(required = false) BigDecimal minCost,
            @RequestParam(required = false) BigDecimal maxCost
    ) {
        Brand brand = new Brand();
        brand.setId(id);

        return service.findCarsByFilters(brand, carType, motorType, minCost, maxCost);
    }
}

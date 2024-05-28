package com.vaika.api.service;

import com.vaika.api.repository.jpa.CarRepository;
import com.vaika.api.repository.model.Brand;
import com.vaika.api.repository.model.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    public List<Car> findCarsByFilters(Brand brand, String carType, String motorType, BigDecimal minCost, BigDecimal maxCost) {
        if ((minCost!= null && maxCost == null) || (minCost == null && maxCost!= null)) {
            throw new IllegalArgumentException("Both minCost and maxCost must be provided together.");
        }
        return carRepository.findByFilters(brand.getId(), carType, motorType, minCost, maxCost);
    }
}

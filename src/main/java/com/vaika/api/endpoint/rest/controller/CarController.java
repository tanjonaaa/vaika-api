package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.CarMapper;
import com.vaika.api.endpoint.rest.model.Car;
import com.vaika.api.service.CarService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarController {
  private final CarService service;
  private final CarMapper mapper;

  @GetMapping("/brands/{id}/cars")
  public List<Car> getCarsByBrand(
      @PathVariable String id,
      @RequestParam(required = false) String carType,
      @RequestParam(required = false) String motorType,
      @RequestParam(required = false) BigDecimal minCost,
      @RequestParam(required = false) BigDecimal maxCost) {
    List<com.vaika.api.repository.model.Car> cars =
        service.findCarsByFilters(id, carType, motorType, minCost, maxCost);
    return cars.stream().map(mapper::toRest).collect(Collectors.toList());
  }
}

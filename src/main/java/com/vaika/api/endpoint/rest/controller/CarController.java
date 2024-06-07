package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.CarMapper;
import com.vaika.api.endpoint.rest.model.Car;
import com.vaika.api.endpoint.rest.model.CrupdateCar;
import com.vaika.api.service.CarService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/cars")
  public List<Car> getCars(@RequestParam(required = false) boolean pinned) {
    return service.findByPins(pinned).stream().map(mapper::toRest).toList();
  }

  @PutMapping("/cars")
  public List<Car> crupdateCars(@RequestBody List<CrupdateCar> toSave) {
    return service.save(toSave).stream().map(mapper::toRest).toList();
  }

  @GetMapping("/cars/{id}")
  public Car getCarById(@PathVariable String id) {
    return mapper.toRest(service.findCarById(id));
  }

  @DeleteMapping("/cars/{id}")
  public Car deleteById(@PathVariable String id) {
    return mapper.toRest(service.deleteCarById(id));
  }
}

package com.vaika.api.service;

import com.vaika.api.endpoint.rest.model.CrupdateCar;
import com.vaika.api.model.exception.NotFoundException;
import com.vaika.api.repository.jpa.CarRepository;
import com.vaika.api.repository.model.Car;
import com.vaika.api.repository.model.mapper.CarMapper;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper domainMapper;

  public List<Car> findCarsByFilters(
      String id, String carType, String motorType, BigDecimal minCost, BigDecimal maxCost) {
    if ((minCost != null && maxCost == null) || (minCost == null && maxCost != null)) {
      throw new IllegalArgumentException("Both minCost and maxCost must be provided together.");
    }

    return carRepository.findByFilters(id, carType, motorType, minCost, maxCost);
  }

  public List<Car> findByPins(boolean pinned) {
    return carRepository.findByPin(pinned);
  }

  public List<Car> save(List<CrupdateCar> toSave) {
    return carRepository.saveAll(createCarsFrom(toSave));
  }

  public Car findCarById(String id) {
    if (id == null) {
      throw new IllegalArgumentException("Car ID cannot be null.");
    }
    return carRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Car with id : " + id + " not found"));
  }

  public Car deleteCarById(String id) {
    Car car = carRepository.deleteByIdReturning(id);
    if (car == null) {
      throw new NotFoundException("Car with id " + id + " not found");
    }
    return car;
  }

  private List<Car> createCarsFrom(List<CrupdateCar> crupdateCars) {
    return crupdateCars.stream().map(domainMapper::toDomain).toList();
  }
}

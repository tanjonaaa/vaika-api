package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Car;
import java.math.BigDecimal;

import com.vaika.api.endpoint.rest.model.CrupdateCar;
import com.vaika.api.repository.jpa.BrandRepository;
import com.vaika.api.repository.jpa.CarTypeRepository;
import com.vaika.api.repository.jpa.MotorTypeRepository;
import com.vaika.api.repository.model.Brand;
import com.vaika.api.repository.model.CarType;
import com.vaika.api.repository.model.MotorType;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public record CarMapper(
        BrandMapper brandMapper,
        ImageMapper imageMapper,
        MotorTypeMapper motorTypeMapper,
        CarTypeMapper carTypeMapper,
        BrandRepository brandRepository,
        CarTypeRepository carTypeRepository,
        MotorTypeRepository motorTypeRepository) {
  public Car toRest(com.vaika.api.repository.model.Car car) {
    return new Car()
        .id(car.getId())
        .name(car.getName())
        .description(car.getDescription())
        .price(BigDecimal.valueOf(car.getPrice()))
        .model(car.getModel())
        .color(car.getColor())
        .power(car.getPower())
        .placeNumber(BigDecimal.valueOf(car.getPlaceNumber()))
        .pinned(car.isPinned())
        .type(carTypeMapper.toRest(car.getType()))
        .motorType(motorTypeMapper.toRest(car.getMotorType()))
        .brand(brandMapper.toRest(car.getBrand()))
        .images(car.getImages().stream().map(imageMapper::toRest).toList());
  }

  public com.vaika.api.repository.model.Car toDomain(CrupdateCar car){
    Brand brand = brandRepository().findById(car.getBrandId()).orElse(null);
    if (brand == null) {
      throw new IllegalArgumentException("Brand with id " + car.getBrandId() + " not found");
    }

    CarType carType = carTypeRepository.findById(car.getTypeId()).orElse(null);
    if (carType == null) {
      throw new IllegalArgumentException("Car type with id " + car.getTypeId() + " not found");
    }

    MotorType motorType = motorTypeRepository.findById(car.getMotorTypeId()).orElse(null);
    if (motorType == null) {
      throw new IllegalArgumentException("Motor type with id " + car.getMotorTypeId() + " not found");
    }

   return com.vaika.api.repository.model.Car.builder()
           .id(car.getId()).
           name(car.getName()).
           description(car.getDescription()).
           price(car.getPrice().doubleValue()).
           model(car.getModel()).
           color(car.getColor()).
           power(car.getPower()).
           placeNumber(car.getPlaceNumber().intValue()).
           brand(brand).
           type(carType).
           motorType(motorType).
           build();
  }
}

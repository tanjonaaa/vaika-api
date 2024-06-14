package com.vaika.api.repository.model.mapper;

import static java.util.Objects.requireNonNull;

import com.vaika.api.endpoint.rest.model.CrupdateCar;
import com.vaika.api.model.exception.BadRequestException;
import com.vaika.api.repository.jpa.BrandRepository;
import com.vaika.api.repository.jpa.CarTypeRepository;
import com.vaika.api.repository.jpa.MotorTypeRepository;
import com.vaika.api.repository.model.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component("carDomainMapper")
@AllArgsConstructor
public class CarMapper {
  private final CarTypeRepository carTypeRepository;
  private final MotorTypeRepository motorTypeRepository;
  private final BrandRepository brandRepository;

  public Car toDomain(CrupdateCar crupdateCar) {
    return Car.builder()
        .id(crupdateCar.getId())
        .description(crupdateCar.getDescription())
        .name(crupdateCar.getName())
        .power(crupdateCar.getPower())
        .price(requireNonNull(crupdateCar.getPrice()).doubleValue())
        .placeNumber(requireNonNull(crupdateCar.getPlaceNumber()).intValue())
        .color(crupdateCar.getColor())
        .model(crupdateCar.getModel())
        .pinned(crupdateCar.getPinned())
        .brand(
            brandRepository
                .findById(requireNonNull(crupdateCar.getBrandId()))
                .orElseThrow(
                    () -> new BadRequestException("Can't find the specified brand of your car")))
        .motorType(
            motorTypeRepository
                .findById(requireNonNull(crupdateCar.getMotorTypeId()))
                .orElseThrow(
                    () ->
                        new BadRequestException("Can't find the specified motor type of your car")))
        .type(
            carTypeRepository
                .findById(requireNonNull(crupdateCar.getTypeId()))
                .orElseThrow(
                    () -> new BadRequestException("Can't find the specified type of your car")))
        .build();
  }
}

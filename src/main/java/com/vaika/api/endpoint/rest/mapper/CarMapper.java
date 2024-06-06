package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Car;
import com.vaika.api.endpoint.rest.model.Image;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("restCarMapper")
public record CarMapper(
    BrandMapper brandMapper,
    ImageMapper imageMapper,
    MotorTypeMapper motorTypeMapper,
    CarTypeMapper carTypeMapper) {
  public Car toRest(com.vaika.api.repository.model.Car domain) {
    return new Car()
        .id(domain.getId())
        .name(domain.getName())
        .description(domain.getDescription())
        .price(BigDecimal.valueOf(domain.getPrice()))
        .model(domain.getModel())
        .color(domain.getColor())
        .power(domain.getPower())
        .placeNumber(BigDecimal.valueOf(domain.getPlaceNumber()))
        .pinned(domain.isPinned())
        .type(carTypeMapper.toRest(domain.getType()))
        .motorType(motorTypeMapper.toRest(domain.getMotorType()))
        .brand(brandMapper.toRest(domain.getBrand()))
        .images(getCarImages(domain));
  }

  private List<Image> getCarImages(com.vaika.api.repository.model.Car car) {
    if (car.getImages() == null) return List.of();
    return car.getImages().stream().map(imageMapper::toRest).toList();
  }
}

package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Car;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public record CarMapper(BrandMapper brandMapper, ImageMapper imageMapper, MotorTypeMapper motorTypeMapper, CarTypeMapper carTypeMapper) {
    public Car toRest(com.vaika.api.repository.model.Car car){
        return new Car().id(car.getId()).name(car.getName()).description(car.getDescription()).price(BigDecimal.valueOf(car.getPrice())).model(car.getModel()).color(car.getColor()).power(car.getPower()).placeNumber(BigDecimal.valueOf(car.getPlaceNumber())).pinned(car.isPinned()).type(carTypeMapper.toRest(car.getType())).motorType(motorTypeMapper.toRest(car.getMotorType())).brand(brandMapper.toRest(car.getBrand())).images(car.getImages().stream().map(imageMapper::toRest).toList());
    }
}

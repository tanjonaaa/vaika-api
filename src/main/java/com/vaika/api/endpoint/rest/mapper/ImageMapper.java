package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Image;
import com.vaika.api.repository.jpa.CarRepository;
import com.vaika.api.repository.model.Car;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {
  private final CarRepository carRepository;

    public ImageMapper(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Image toRest(com.vaika.api.repository.model.Image image) {
    return new Image().id(image.getId()).url(image.getUrl()).carId(image.getCar().getId());
  }

  public com.vaika.api.repository.model.Image toDomain(Image image) {
    Car car = carRepository.findById(image.getCarId()).orElse(null);
    return com.vaika.api.repository.model.Image.builder()
            .id(image.getId())
            .url(image.getUrl())
            .car(car)
            .build();
  }
}

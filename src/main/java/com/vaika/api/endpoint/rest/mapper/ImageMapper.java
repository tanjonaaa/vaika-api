package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {
  public Image toRest(com.vaika.api.repository.model.Image image) {
    return new Image().id(image.getId()).url(image.getUrl()).carId(image.getCar().getId());
  }
}

package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.ImageMapper;
import com.vaika.api.endpoint.rest.model.Image;
import com.vaika.api.service.ImageService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ImageController {
  private final ImageService imageService;
  private final ImageMapper imageMapper;

  @PutMapping("/images")
  public List<Image> attachImage(@RequestBody List<Image> images) {
    return imageService.attachImageWithCar(images).stream().map(imageMapper::toRest).toList();
  }

  @DeleteMapping("/images/{id}")
  public Image deleteImage(@PathVariable String id) {
    return imageMapper.toRest(imageService.deleteImage(id));
  }
}

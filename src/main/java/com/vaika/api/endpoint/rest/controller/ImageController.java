package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.ImageMapper;
import com.vaika.api.endpoint.rest.model.Image;
import java.util.List;

import com.vaika.api.service.ImageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("images")
public class ImageController {
  private final ImageService imageService;
  private final ImageMapper imageMapper;

    public ImageController(ImageService imageService, ImageMapper imageMapper) {
        this.imageService = imageService;
        this.imageMapper = imageMapper;
    }

    @PutMapping
    public List<Image> attachImage(@RequestBody List<Image> images) {
      return imageService.attachImageWithCar(images).stream().map(imageMapper::toRest).toList();
    }

    @DeleteMapping("{id}")
    public Image deleteImage(@PathVariable String id) {
        return imageMapper.toRest(imageService.deleteImage(id));
    }
}

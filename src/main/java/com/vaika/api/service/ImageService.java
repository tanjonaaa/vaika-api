package com.vaika.api.service;

import com.vaika.api.endpoint.rest.mapper.ImageMapper;
import com.vaika.api.model.exception.NotFoundException;
import com.vaika.api.repository.jpa.ImageRepository;
import com.vaika.api.repository.model.Image;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageService {
  private final ImageMapper mapper;
  private final ImageRepository imageRepository;
  public List<Image> attachImageWithCar(List<com.vaika.api.endpoint.rest.model.Image> images) {
    return imageRepository.saveAll(attachImageWithCarFrom(images));
  }

  private List<Image> attachImageWithCarFrom(List<com.vaika.api.endpoint.rest.model.Image> image) {
    return image.stream().map(mapper::toDomain).toList();
  }

  public Image deleteImage(String id){
    Image image = imageRepository.deleteByIdReturning(id);
    if (image == null){
      throw new NotFoundException("Image with id " + id + " not found");
    }
    return image;
  }
}

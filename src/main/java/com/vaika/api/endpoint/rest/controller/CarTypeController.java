package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.CarTypeMapper;
import com.vaika.api.endpoint.rest.model.Type;
import com.vaika.api.service.CarTypeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarTypeController {
  private final CarTypeService carTypeService;
  private final CarTypeMapper carTypeMapper;

  @GetMapping("/car-types")
  public List<Type> getAllCarTypePaginate(
      @RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "6") int size) {
    return carTypeService
        .findAllCarType(PageRequest.of(page, size))
        .map(carTypeMapper::toRest)
        .toList();
  }
}

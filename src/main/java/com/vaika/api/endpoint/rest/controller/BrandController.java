package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.BrandMapper;
import com.vaika.api.endpoint.rest.model.Brand;
import com.vaika.api.service.BrandService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BrandController {
  private final BrandService service;
  private final BrandMapper mapper;

  @GetMapping("/brands")
  public List<Brand> getPaginatedBrands(@PageableDefault(size = 6) Pageable pageable) {
    Page<com.vaika.api.repository.model.Brand> brands = service.findAll(pageable);
    return brands.getContent().stream().map(mapper::toRest).toList();
  }
}

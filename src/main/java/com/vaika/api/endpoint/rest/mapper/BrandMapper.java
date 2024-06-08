package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

  public Brand toRest(com.vaika.api.repository.model.Brand brand) {
    return new Brand().id(brand.getId()).name(brand.getName()).logoUrl(brand.getLogoUrl());
  }
}

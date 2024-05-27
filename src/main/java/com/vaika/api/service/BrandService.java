package com.vaika.api.service;

import com.vaika.api.repository.jpa.BrandRepository;
import com.vaika.api.repository.model.Brand;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandService {
  private final BrandRepository repository;

  public Page<Brand> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}

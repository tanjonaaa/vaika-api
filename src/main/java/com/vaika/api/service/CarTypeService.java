package com.vaika.api.service;

import com.vaika.api.repository.jpa.CarTypeRepository;
import com.vaika.api.repository.model.CarType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarTypeService {
  private final CarTypeRepository repository;

  public Page<CarType> findAllCarType(Pageable pageable) {
    return repository.findAll(pageable);
  }
}

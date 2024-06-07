package com.vaika.api.service;

import com.vaika.api.repository.jpa.MotorTypeRepository;
import com.vaika.api.repository.model.MotorType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MotorTypeService {
    private final MotorTypeRepository repository;

    public Page<MotorType> findAllMotorType(Pageable pageable){
        return repository.findAll(pageable);
    }
}

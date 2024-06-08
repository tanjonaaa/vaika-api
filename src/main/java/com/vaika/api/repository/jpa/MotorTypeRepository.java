package com.vaika.api.repository.jpa;

import com.vaika.api.repository.model.MotorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorTypeRepository extends JpaRepository<MotorType, String> {}

package com.vaika.api.repository.jpa;

import com.vaika.api.repository.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, String> {
}

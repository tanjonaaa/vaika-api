package com.vaika.api.repository.jpa;

import com.vaika.api.repository.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {}

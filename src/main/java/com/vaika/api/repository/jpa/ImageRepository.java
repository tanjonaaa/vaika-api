package com.vaika.api.repository.jpa;

import com.vaika.api.repository.model.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
  @Transactional
  @Query(value = "DELETE FROM Image WHERE id = :id RETURNING *", nativeQuery = true)
  Image deleteByIdReturning(String id);
}

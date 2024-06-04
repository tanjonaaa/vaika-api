package com.vaika.api.repository.jpa;

import com.vaika.api.repository.model.User;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);

  @Transactional
  @Query(value = "DELETE FROM User WHERE id = :id RETURNING *", nativeQuery = true)
  User deleteByIdReturning(@Param("id") String id);
}

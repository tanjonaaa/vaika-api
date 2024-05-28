package com.vaika.api.repository.jpa;

import com.vaika.api.repository.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    @Query("SELECT c FROM Car c WHERE (:brandId IS NULL OR c.brand.id = :brandId) " +
            "AND (:carType IS NULL OR c.type.name = :carType) " +
            "AND (:motorType IS NULL OR c.motorType.name = :motorType) " +
            "AND (:minCost IS NULL OR c.price >= :minCost) " +
            "AND (:maxCost IS NULL OR c.price <= :maxCost)")
    List<Car> findByFilters(
            @Param("brandId") String brandId,
            @Param("carType") String carType,
            @Param("motorType") String motorType,
            @Param("minCost") BigDecimal minCost,
            @Param("maxCost") BigDecimal maxCost);
}

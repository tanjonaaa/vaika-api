package com.vaika.api.repository.jpa;

import com.vaika.api.repository.model.Appointment;
import com.vaika.api.repository.model.Enum.AppointmentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    @Query("SELECT a FROM Appointment a WHERE a.status = :status")
    List<Appointment> findByStatus(@Param("status") AppointmentStatusEnum status);

    @Query("SELECT a FROM Appointment a WHERE a.id = :id")
    Appointment findByAppId(
            @Param("id") String id
    );
}
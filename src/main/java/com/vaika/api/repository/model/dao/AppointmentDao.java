package com.vaika.api.repository.model.dao;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentDao {
  private String id;
  private String lastname;
  private String firstName;
  private String email;
  private String contact;
  private String message;
  private Instant appointmentDateTime;
  private String idCar;
}

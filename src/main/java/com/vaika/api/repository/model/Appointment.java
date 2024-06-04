package com.vaika.api.repository.model;

import com.vaika.api.repository.model.enums.AppointmentStatusEnum;
import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
  @Id private String id;
  private String lastName;
  private String firstName;
  private String email;
  private String contact;
  private String message;
  private Instant appointmentDateTime;
  @ManyToOne private Car car;

  @Enumerated(EnumType.STRING)
  private AppointmentStatusEnum status;
}

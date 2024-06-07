package com.vaika.api.repository.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.vaika.api.repository.model.enums.AppointmentStatusEnum;
import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;

  private String lastName;
  private String firstName;
  private String email;
  private String contact;
  private String message;
  private Instant appointmentDatetime;
  @ManyToOne private Car car;

  @Enumerated(EnumType.STRING)
  private AppointmentStatusEnum status;
}

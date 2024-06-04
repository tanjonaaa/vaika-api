package com.vaika.api.repository.model;

import com.vaika.api.repository.model.Enum.AppointmentStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    private String id;
    private String lastName;
    private String firstName;
    private String email;
    private String contact;
    private String message;
    private Instant appointmentDateTime;
    @ManyToOne
    private Car car;
    @Enumerated(EnumType.STRING)
    private AppointmentStatusEnum status;

}

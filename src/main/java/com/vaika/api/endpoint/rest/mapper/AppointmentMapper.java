package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppointmentMapper {
  private final CarMapper carMapper;
  private final AppointmentStatusEnumMapper appointmentStatusEnumMapper;

  public Appointment toRest(com.vaika.api.repository.model.Appointment appointment) {
    return new Appointment()
        .id(appointment.getId())
        .car(carMapper.toRest(appointment.getCar()))
        .appointmentDatetime(appointment.getAppointmentDateTime())
        .email(appointment.getEmail())
        .contact(appointment.getContact())
        .firstName(appointment.getFirstName())
        .lastName(appointment.getLastName())
        .message(appointment.getMessage())
        .status(appointmentStatusEnumMapper.toRest(appointment.getStatus()));
  }
}

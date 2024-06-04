package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Appointment;
import com.vaika.api.endpoint.rest.model.CrupdateAppointment;
import com.vaika.api.model.exception.BadRequestException;
import com.vaika.api.repository.jpa.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppointmentMapper {
  private final CarMapper carMapper;
  private final AppointmentStatusEnumMapper appointmentStatusEnumMapper;
  private final CarRepository carRepository;

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

  public com.vaika.api.repository.model.Appointment toDomain(CrupdateAppointment appointment) {
    com.vaika.api.repository.model.Car car =
        carRepository
            .findById(appointment.getCarId())
            .orElseThrow(
                () ->
                    new BadRequestException(
                        "The car with the id " + appointment.getCarId() + " is not found"));

    return com.vaika.api.repository.model.Appointment.builder()
        .id(appointment.getId())
        .email(appointment.getEmail())
        .contact(appointment.getContact())
        .appointmentDateTime(appointment.getAppointmentDatetime())
        .firstName(appointment.getFirstName())
        .lastName(appointment.getLastName())
        .status(appointmentStatusEnumMapper.toDomain(appointment.getStatus()))
        .car(car)
        .build();
  }
}

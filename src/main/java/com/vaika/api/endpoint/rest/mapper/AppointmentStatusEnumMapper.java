package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Appointment;
import com.vaika.api.endpoint.rest.model.CrupdateAppointment;
import com.vaika.api.repository.model.enums.AppointmentStatusEnum;
import org.springframework.stereotype.Component;

@Component
public class AppointmentStatusEnumMapper {
  public Appointment.StatusEnum toRest(AppointmentStatusEnum domain) {
    return switch (domain) {
      case PENDING -> Appointment.StatusEnum.PENDING;
      case VALIDATED -> Appointment.StatusEnum.VALIDATED;
      case REJECTED -> Appointment.StatusEnum.REJECTED;
      case ARCHIVED -> Appointment.StatusEnum.ARCHIVED;
    };
  }

  public AppointmentStatusEnum toDomain(CrupdateAppointment.StatusEnum rest) {
    return switch (rest) {
      case PENDING -> AppointmentStatusEnum.PENDING;
      case VALIDATED -> AppointmentStatusEnum.VALIDATED;
      case REJECTED -> AppointmentStatusEnum.REJECTED;
      case ARCHIVED -> AppointmentStatusEnum.ARCHIVED;
    };
  }
}

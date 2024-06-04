package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.AppointmentStatusEnum;
import org.springframework.stereotype.Component;

@Component
public class AppointmentStatusEnumMapper {
  public AppointmentStatusEnum toRest(
      com.vaika.api.repository.model.enums.AppointmentStatusEnum appointmentStatusEnum) {
    if (appointmentStatusEnum == null) {
      return null;
    } else {
      return AppointmentStatusEnum.valueOf(appointmentStatusEnum.name());
    }
  }

  public com.vaika.api.repository.model.enums.AppointmentStatusEnum toDomain(
      AppointmentStatusEnum appointmentStatusEnum) {
    return com.vaika.api.repository.model.enums.AppointmentStatusEnum.valueOf(
        appointmentStatusEnum.name());
  }
}

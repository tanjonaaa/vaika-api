package com.vaika.api.repository.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppointmentStatusEnum {
  PENDING,
  VALIDATED,
  REJECTED,
  ARCHIVED
}

package com.vaika.api.repository.model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppointmentStatusEnum {
    PENDING("PENDING"),
    VALIDATED("VALIDATED"),
    REJECTED("REJECTED"),
    ARCHIVED("ARCHIVED");

    AppointmentStatusEnum(String value) {

    }
}

package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.MotorType;
import org.springframework.stereotype.Component;

@Component
public class MotorTypeMapper {
    public MotorType toRest(com.vaika.api.repository.model.MotorType motorType){
        return new MotorType().id(motorType.getId()).name(motorType.getName());
    }
}

package com.vaika.api.endpoint.rest.mapper;

import com.vaika.api.endpoint.rest.model.Type;
import org.springframework.stereotype.Component;

@Component
public class CarTypeMapper {
    public Type toRest(com.vaika.api.repository.model.CarType carType){
        return new Type().id(carType.getId()).name(carType.getName());
    }
}

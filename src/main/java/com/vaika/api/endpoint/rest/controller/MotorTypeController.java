package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.MotorTypeMapper;
import com.vaika.api.endpoint.rest.model.MotorType;
import com.vaika.api.service.MotorTypeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MotorTypeController {
    private final MotorTypeService motorTypeService;
    private final MotorTypeMapper motorTypeMapper;

    @GetMapping("/motor-type")
    public List<MotorType> getAllMotorTypePaginate(@RequestParam(required = false,defaultValue = "0") int page,
                                                   @RequestParam(required = false,defaultValue = "6" ) int size){
        Page<com.vaika.api.repository.model.MotorType> motorTypes =
                motorTypeService.findAllMotorType(PageRequest.of(page,size));
        return motorTypes.map(motorTypeMapper::toRest).toList();
    }
}

package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.AppointmentMapper;
import com.vaika.api.endpoint.rest.model.Appointment;
import com.vaika.api.repository.model.Enum.AppointmentStatusEnum;
import com.vaika.api.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class AppointmentController {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getPaginatedAppointmentsByStatus(
            @RequestParam AppointmentStatusEnum status,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {

        Page<com.vaika.api.repository.model.Appointment> appointments = appointmentService.findAppointmentsByStatus(status, pageNumber, pageSize);
        return appointments.getContent().stream().map(appointmentMapper::toRest).toList();
    }

    @GetMapping("/appointments/{id}")
    public Appointment getById(
            @PathVariable String id
    ){
        return appointmentMapper.toRest(appointmentService.findById(id));
    }

    @PostMapping("/appointments")
    public Appointment save(
            @RequestBody com.vaika.api.repository.model.dao.AppointmentDao appointment
    ){
        return appointmentMapper.toRest(appointmentService.save(appointment));
    }

    @PutMapping("/appointments")
    public Appointment update(
            @RequestBody com.vaika.api.repository.model.dao.AppointmentDao appointment
    ){
        return appointmentMapper.toRest(appointmentService.update(appointment));
    }
}

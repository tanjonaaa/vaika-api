package com.vaika.api.endpoint.rest.controller;

import com.vaika.api.endpoint.rest.mapper.AppointmentMapper;
import com.vaika.api.endpoint.rest.model.Appointment;
import com.vaika.api.endpoint.rest.model.CrupdateAppointment;
import com.vaika.api.repository.model.enums.AppointmentStatusEnum;
import com.vaika.api.service.AppointmentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class AppointmentController {
  private final AppointmentMapper mapper;
  private final AppointmentService appointmentService;

  @GetMapping("/appointments")
  public List<Appointment> getPaginatedAppointmentsByStatus(
      @RequestParam AppointmentStatusEnum status,
      @RequestParam(defaultValue = "0") int pageNumber,
      @RequestParam(defaultValue = "10") int pageSize) {

    Page<com.vaika.api.repository.model.Appointment> appointments =
        appointmentService.findAppointmentsByStatus(status, pageNumber, pageSize);
    return appointments.getContent().stream().map(mapper::toRest).toList();
  }

  @GetMapping("/appointments/{id}")
  public Appointment getById(@PathVariable String id) {
    return mapper.toRest(appointmentService.findById(id));
  }

  @PutMapping("/appointments")
  public List<Appointment> saveAppointments(@RequestBody List<CrupdateAppointment> toSave) {
    return appointmentService.save(toSave).stream().map(mapper::toRest).toList();
  }
}

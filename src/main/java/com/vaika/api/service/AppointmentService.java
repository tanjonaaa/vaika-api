package com.vaika.api.service;

import com.vaika.api.endpoint.rest.mapper.AppointmentMapper;
import com.vaika.api.endpoint.rest.model.CrupdateAppointment;
import com.vaika.api.repository.jpa.AppointmentRepository;
import com.vaika.api.repository.model.Appointment;
import com.vaika.api.repository.model.enums.AppointmentStatusEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
  private final AppointmentRepository appointmentRepository;
  private final AppointmentMapper mapper;

  public Page<Appointment> findAppointmentsByStatus(
      AppointmentStatusEnum status, int pageNumber, int pageSize) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    List<Appointment> filteredAppointments = appointmentRepository.findByStatus(status);

    return new PageImpl<>(filteredAppointments, pageable, filteredAppointments.size());
  }

  public Appointment findById(String id) {
    return appointmentRepository.findByAppId(id);
  }

  public List<Appointment> save(List<CrupdateAppointment> toSave) {
    return this.appointmentRepository.saveAll(createAppointmentsFrom(toSave));
  }

  private List<Appointment> createAppointmentsFrom(List<CrupdateAppointment> crupdateAppointments) {
    return crupdateAppointments.stream().map(mapper::toDomain).toList();
  }
}

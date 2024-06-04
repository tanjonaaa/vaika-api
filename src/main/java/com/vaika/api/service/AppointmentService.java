package com.vaika.api.service;

import com.vaika.api.model.exception.NotFoundException;
import com.vaika.api.repository.jpa.AppointmentRepository;
import com.vaika.api.repository.jpa.CarRepository;
import com.vaika.api.repository.model.Appointment;
import com.vaika.api.repository.model.Enum.AppointmentStatusEnum;
import com.vaika.api.repository.model.dao.AppointmentDao;
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
  private final CarRepository carRepository;

  public Page<Appointment> findAppointmentsByStatus(
      AppointmentStatusEnum status, int pageNumber, int pageSize) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    List<Appointment> filteredAppointments = appointmentRepository.findByStatus(status);

    return new PageImpl<>(filteredAppointments, pageable, filteredAppointments.size());
  }

  public Appointment findById(String id) {
    return appointmentRepository.findByAppId(id);
  }

  public Appointment save(AppointmentDao toSave) {
    Appointment appointment = new Appointment();
    appointment.setId(toSave.getId());
    appointment.setLastName(toSave.getLastname());
    appointment.setFirstName(toSave.getFirstName());
    appointment.setContact(toSave.getContact());
    appointment.setMessage(toSave.getMessage());
    appointment.setAppointmentDateTime(toSave.getAppointmentDateTime());
    appointment.setStatus(AppointmentStatusEnum.PENDING);
    appointment.setCar(
        carRepository
            .findById(toSave.getIdCar())
            .orElseThrow(
                () -> new NotFoundException("Car with id : " + toSave.getIdCar() + " not found")));
    return appointmentRepository.save(appointment);
  }

  public Appointment update(AppointmentDao toUpdate) {
    Appointment appointment =
        appointmentRepository
            .findById(toUpdate.getId())
            .orElseThrow(() -> new RuntimeException("Appointment not found"));
    appointment.setId(toUpdate.getId());
    appointment.setLastName(toUpdate.getLastname());
    appointment.setFirstName(toUpdate.getFirstName());
    appointment.setEmail(toUpdate.getEmail());
    appointment.setContact(toUpdate.getContact());
    appointment.setMessage(toUpdate.getMessage());
    appointment.setAppointmentDateTime(toUpdate.getAppointmentDateTime());
    appointment.setCar(
        carRepository
            .findById(toUpdate.getIdCar())
            .orElseThrow(
                () ->
                    new NotFoundException("Car with id : " + toUpdate.getIdCar() + " not found")));
    appointment.setStatus(AppointmentStatusEnum.PENDING);

    return appointmentRepository.save(appointment);
  }
}

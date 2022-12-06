package com.hackbright.medi3.services;

import com.hackbright.medi3.dtos.AppointmentDTO;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<AppointmentDTO> getAllAppointmentsByPatientId(Long patientId);

    List<AppointmentDTO> getAllAppointmentsByDoctorId(Long doctorId);

    @Transactional
    void addAppointment(AppointmentDTO appointmentDto, Long patientId);

    Optional<AppointmentDTO> getAppointmentById(Long appointmentId);

    @Transactional
    void deleteAppointmentById(Long appointmentId);

    @Transactional
    void changeStatusAppointmentById(Long appointmentId);

    @Transactional
    void updateAppointmentById(AppointmentDTO appointmentDto);
}

package com.hackbright.medi3.services.Impl;


import com.hackbright.medi3.dtos.AppointmentDTO;
import com.hackbright.medi3.entities.Appointment;
import com.hackbright.medi3.entities.Doctor;
import com.hackbright.medi3.entities.Patient;
import com.hackbright.medi3.repositories.AppointmentRepository;
import com.hackbright.medi3.repositories.DoctorRepository;
import com.hackbright.medi3.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements com.hackbright.medi3.services.AppointmentService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentDTO> getAllAppointmentsByPatientId(Long patientId){
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()){
            List<Appointment> appointmentList = appointmentRepository.findAllByPatientEquals(patientOptional.get());
            return appointmentList.stream().map(appointment -> new AppointmentDTO(appointment)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<AppointmentDTO> getAllAppointmentsByDoctorId(Long doctorId){
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isPresent()){
            List<Appointment> appointmentList = appointmentRepository.findAllByDoctorEquals(doctorOptional.get());
            return appointmentList.stream().map(appointment -> new AppointmentDTO(appointment)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addAppointment(AppointmentDTO appointmentDto, Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Optional<Doctor> doctorOptional = doctorRepository.findById((long) 1);

        Appointment appointment = new Appointment(appointmentDto);
        patientOptional.ifPresent(appointment::setPatient);
        doctorOptional.ifPresent(appointment::setDoctor);
        appointmentRepository.saveAndFlush(appointment);
    }

    @Override
    public Optional<AppointmentDTO> getAppointmentById(Long appointmentId) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        if (appointmentOptional.isPresent()){
            return Optional.of(new AppointmentDTO(appointmentOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void deleteAppointmentById(Long appointmentId) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        appointmentOptional.ifPresent(appointment -> appointmentRepository.delete(appointment));
    }

    @Override
    @Transactional
    public void changeStatusAppointmentById(Long appointmentId) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        appointmentOptional.ifPresent(appointment -> {
            appointment.setStatus("confirmed");
            appointmentRepository.saveAndFlush(appointment);
        });
    }

    @Override
    @Transactional
    public void updateAppointmentById(AppointmentDTO appointmentDto) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentDto.getId());
        appointmentOptional.ifPresent(appointment -> {

            appointment.setDepartment(appointmentDto.getDepartment());
            appointment.setRDate(appointmentDto.getRDate());
            appointment.setRTime(appointmentDto.getRTime());
            appointment.setAppcategory(appointmentDto.getAppcategory());
            appointmentRepository.saveAndFlush(appointment);
        });
    }
}

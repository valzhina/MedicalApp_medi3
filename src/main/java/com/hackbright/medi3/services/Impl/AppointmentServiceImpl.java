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
    public List<AppointmentDTO> getAllAppointmentsByDoctorIdForDate(Long doctorId, String date){
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        System.out.println("\n\n" + date + "\n");
        if (doctorOptional.isPresent()){
            List<Appointment> appointmentList = appointmentRepository.findAllByDoctorEquals(doctorOptional.get());
            List<Appointment> busyList = new ArrayList<Appointment>();
            System.out.println("\n\n" + "created applist and busylist" + "\n\n");
            for(Appointment app: appointmentList) {
                System.out.println(app.getRtime() + "\n\n");
                System.out.println("\n\n" + app.getRdate() + "\n" + date + "\n\n");
                if(app.getRdate().equals(date)){
                    busyList.add(app);
                }
            }
            return busyList.stream().map(appointment -> new AppointmentDTO(appointment)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addAppointment(AppointmentDTO appointmentDto, Long patientId, Long doctorId) {
        System.out.println("\n\n\n");
        System.out.println(doctorId);
        System.out.println("\n\n\n");
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        System.out.println("\n\n\nIN SERVICES: got doctor and patients from repo. Now gonna create appointment from dto;\n\n\n");
        Appointment appointment = new Appointment(appointmentDto);
        System.out.println("\n\n\nIN SERVICES: created appointment from DTO\n\n\n");
        patientOptional.ifPresent(appointment::setPatient);
        System.out.println("\n\n\nIN SERVICES: added patient to appointment\n\n\n");
        doctorOptional.ifPresent(appointment::setDoctor);
        System.out.println("\n\n\nIN SERVICES: added doctor to appointment\n\n\n");
        System.out.println(appointmentDto.toString() +"\n\n\n");

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
//            appointment.setRDate(appointmentDto.getRDate());
//            appointment.setRTime(appointmentDto.getRTime());
            appointment.setAppcategory(appointmentDto.getAppcategory());
            appointmentRepository.saveAndFlush(appointment);
        });
    }
}

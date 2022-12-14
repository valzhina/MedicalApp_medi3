package com.hackbright.medi3.controllers;

import com.hackbright.medi3.dtos.AppointmentDTO;
import com.hackbright.medi3.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/patient/{patientId}")
    public List<AppointmentDTO> getAppointmentByPatient(@PathVariable Long patientId){
        System.out.println("\n\n\nget appointments\n\n\n");
        return appointmentService.getAllAppointmentsByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<AppointmentDTO> getAppointmentByDoctor(@PathVariable Long doctorId){
        return appointmentService.getAllAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/times/{doctorId}/{date}")
    public List<AppointmentDTO> getByDoctorDate(@PathVariable Long doctorId, @PathVariable String date){
        return appointmentService.getAllAppointmentsByDoctorIdForDate(doctorId, date);
    }

    @GetMapping("/{appointmentId}")
    public Optional<AppointmentDTO> getAppointmentById(@PathVariable Long appointmentId){
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping("/patient/{patientId}/{doctorId}")
    public void addAppointment(@RequestBody AppointmentDTO appointmentDto,@PathVariable Long patientId, @PathVariable Long doctorId) {
//        System.out.println("\n\n\nIN CONTROLLER");
//        System.out.println(doctorId);
//        System.out.println("\n\n\n");
        appointmentService.addAppointment(appointmentDto, patientId, doctorId);
    }

    @DeleteMapping("/{appointmentId}")
    public void deleteAppointmentById(@PathVariable Long appointmentId){ appointmentService.deleteAppointmentById(appointmentId);
    }

    @PutMapping("/{appointmentId}")
    public void changeStatusAppointmentById(@PathVariable Long appointmentId){
        appointmentService.changeStatusAppointmentById(appointmentId);
    }

    @PutMapping
    public void updateAppointment(@RequestBody AppointmentDTO appointmentDto){ appointmentService.updateAppointmentById(appointmentDto);
    }
}
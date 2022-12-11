package com.hackbright.medi3.dtos;


import com.hackbright.medi3.entities.Appointment;
import com.hackbright.medi3.entities.Doctor;
import com.hackbright.medi3.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentDTO {

    private Long id;
    private Doctor doctor;
    private Patient patient;
    private String department;
    private String rdate;
    private String rtime;
    private String appcategory;
    private String status;

    public AppointmentDTO(Appointment appointment) {
        if (appointment.getId() != null) {
            this.id = appointment.getId();
        }
        if (appointment.getDoctor() != null) {
            this.doctor = appointment.getDoctor();
        }
        if (appointment.getPatient() != null) {
            this.patient = appointment.getPatient();
        }
        if (appointment.getDepartment() != null) {
            this.department = appointment.getDepartment();
        }
        if (appointment.getRdate() != null) {
            this.rdate = appointment.getRdate();
        }
        if (appointment.getRtime() != null) {
            this.rtime = appointment.getRtime();
        }
        if (appointment.getAppcategory() != null) {
            this.appcategory = appointment.getAppcategory();
        }
        if (appointment.getStatus() != null) {
            this.status = appointment.getStatus();
        }
    }

    public String toString() {
        return "department: " + getDepartment() +
                "\nappcategory: " + getAppcategory() +
                "\nstatus: " + getStatus() +
                "\nrDate: " + getRdate() +
                "\nrTime: " + getRtime();
    }
}


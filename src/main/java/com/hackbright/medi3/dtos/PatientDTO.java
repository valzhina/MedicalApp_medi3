package com.hackbright.medi3.dtos;

import com.hackbright.medi3.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientDTO implements Serializable {
    private Long id;
    private String patientName;
    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private String address;
    private String photo;
    private String phone;
    private String password;
//    private Doctor assignedDoctor;
//    private Set<Prescription> medicines = new HashSet<>();
    private Set<AppointmentDTO> appointmentsDtoSet = new HashSet<>();

    public PatientDTO(Patient patient) {
        if (patient.getId() != null) {
            this.id = patient.getId();
        }
        if (patient.getPatientName() != null) {
            this.patientName = patient.getPatientName();
        }
        if (patient.getFirstName() != null) {
            this.firstName = patient.getFirstName();
        }
        if (patient.getLastName() != null) {
            this.lastName = patient.getLastName();
        }
        if (patient.getEmail() != null) {
            this.email = patient.getEmail();
        }
        if (patient.getBirthDate() != null) {
            this.birthDate = patient.getBirthDate();
        }
        if (patient.getAddress() != null) {
            this.address = patient.getAddress();
        }
        if (patient.getPhoto() != null) {
            this.photo = patient.getPhoto();
        }
        if (patient.getPhone() != null) {
            this.phone = patient.getPhone();
        }
        if (patient.getPassword() != null) {
            this.password = patient.getPassword();
        }
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", photo='" + photo + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
//                ", assignedDoctor=" + assignedDoctor +
//                ", medicines=" + medicines +
//                ", appointments=" + appointments +
                '}';
    }
}


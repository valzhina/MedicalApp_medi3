package com.hackbright.medi3.dtos;


import com.hackbright.medi3.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class DoctorDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
//    private List<Patient> patientList;
    private String email;
    private String doctor_id;
    private Set<AppointmentDTO> AppointmentDtoSet = new HashSet<>();

    public DoctorDTO(Doctor doctor){
        if (doctor.getId() != null) {
            this.id = doctor.getId();
        }
        if (doctor.getFirstName() != null) {
            this.firstName = doctor.getFirstName();
        }
        if (doctor.getLastName() != null) {
            this.lastName = doctor.getLastName();
        }
        if (doctor.getEmail() != null) {
            this.email = doctor.getEmail();
        }
//        if (doctor.getPatientList() != null) {
//        this.patientList = doctor.getPatientList();
//        }
        if (doctor.getPassword() != null) {
            this.password = doctor.getPassword();
        }
    }


    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", doctor_id='" + doctor_id + '\'' +
//                ", patientList=" + patientList +
                ", email='" + email + '\'' +
                '}';
    }
}


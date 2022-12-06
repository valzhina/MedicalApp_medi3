package com.hackbright.medi3.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hackbright.medi3.dtos.PatientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Patients")
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String patientName;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column
    private String birthDate;

    @Column
    private String address;

    @Column
    private String photo;

    @Column
    private String phone;

    @Column
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Doctor assignedDoctor;


    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference
    private Set<Appointment> appointmentSet = new HashSet<>();

    public Patient(PatientDTO patientDto) {
        if (patientDto.getPatientName() != null) {
            this.patientName = patientDto.getPatientName();
        }
        if (patientDto.getFirstName() != null) {
            this.firstName = patientDto.getFirstName();
        }
        if (patientDto.getLastName() != null) {
            this.lastName = patientDto.getLastName();
        }
        if (patientDto.getEmail() != null) {
            this.email = patientDto.getEmail();
        }
        if (patientDto.getBirthDate() != null) {
            this.birthDate = patientDto.getBirthDate();
        }
        if (patientDto.getAddress() != null) {
            this.address = patientDto.getAddress();
        }
        if (patientDto.getPhoto() != null) {
            this.photo = patientDto.getPhoto();
        }
        if (patientDto.getPhone() != null) {
            this.phone = patientDto.getPhone();
        }
        if (patientDto.getPassword() != null) {
            this.password = patientDto.getPassword();
        }
    }
}


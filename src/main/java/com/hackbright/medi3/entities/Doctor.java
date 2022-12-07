package com.hackbright.medi3.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hackbright.medi3.dtos.DoctorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "password")
    private String password;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "doctor_id", unique = true)
    private String doctor_id;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})

    @JsonBackReference
    private Set<Appointment> appointmentSet = new HashSet<>();


    public Doctor(DoctorDTO doctorDto){
        if (doctorDto.getFirstName() != null) {
            this.firstName = doctorDto.getFirstName();
        }
        if (doctorDto.getLastName() != null) {
            this.lastName = doctorDto.getLastName();
        }
        if (doctorDto.getDoctor_id() != null) {
            this.doctor_id = doctorDto.getDoctor_id();
        }
        if (doctorDto.getEmail() != null) {
            this.email = doctorDto.getEmail();
        }
        if (doctorDto.getPassword() != null) {
            this.password = doctorDto.getPassword();
        }
    }

//    @Override
//    public String toString() {
//        return "Doctor{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", password='" + password + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", doctor_id='" + doctor_id + '\'' +
//                ", email='" + email + '\'' +
//                ", appointmentSet=" + appointmentSet +
//                '}';
//    }
}


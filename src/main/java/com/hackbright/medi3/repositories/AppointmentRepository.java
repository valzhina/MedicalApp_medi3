package com.hackbright.medi3.repositories;


import com.hackbright.medi3.entities.Appointment;
import com.hackbright.medi3.entities.Doctor;
import com.hackbright.medi3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByDoctorEquals(Doctor doctor);
    List<Appointment> findAllByPatientEquals(Patient patient);
}

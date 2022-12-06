package com.hackbright.medi3.repositories;


import com.hackbright.medi3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByPatientName(String patientName);
    Optional<Patient> findByEmail(String email);
}

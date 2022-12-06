package com.hackbright.medi3.services;

import com.hackbright.medi3.dtos.PatientDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PatientService {
    @Transactional
    List<String> addPatient(PatientDTO patientDto);

    List<String> patientLogin(PatientDTO patientDto);
}

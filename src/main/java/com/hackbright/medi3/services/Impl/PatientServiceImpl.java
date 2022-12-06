package com.hackbright.medi3.services.Impl;



import com.hackbright.medi3.dtos.PatientDTO;
import com.hackbright.medi3.entities.Patient;
import com.hackbright.medi3.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements com.hackbright.medi3.services.PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addPatient(PatientDTO patientDto){
        List<String> response = new ArrayList<>();
        Patient patient = new Patient(patientDto);
        patientRepository.saveAndFlush(patient);
        response.add("http://localhost:8080/loginpatient.html");
        return response;
    }

    @Override
    public List<String> patientLogin(PatientDTO patientDto){
        List<String> response = new ArrayList<>();
        Optional<Patient> patientOptional = patientRepository.findByPatientName(patientDto.getPatientName());

        if (patientOptional.isPresent()){
            // check to see if the password matches the hash by two conditional statements
            if (passwordEncoder.matches(patientDto.getPassword(), patientOptional.get().getPassword())){
                response.add("http://localhost:8080/patienthome.html");
                response.add(String.valueOf(patientOptional.get().getId()));
            } else {
                response.add("Username or password incorrect");
            }
        } else {
            response.add("Username or password incorrect");
        }
        return response;
    }
}
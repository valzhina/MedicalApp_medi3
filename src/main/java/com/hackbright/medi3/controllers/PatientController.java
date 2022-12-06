package com.hackbright.medi3.controllers;

import com.hackbright.medi3.dtos.PatientDTO;
import com.hackbright.medi3.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public List<String> addPatient(@RequestBody PatientDTO patientDto) {
        String passHash = passwordEncoder.encode(patientDto.getPassword());
        patientDto.setPassword(passHash);
        return patientService.addPatient(patientDto);
    }
    @PostMapping("/login")
    public List<String> patientLogin(@RequestBody PatientDTO patientDto){
        System.out.println("\n\n\n We are here!!!\n\n\n");
        return patientService.patientLogin(patientDto);
    }
}

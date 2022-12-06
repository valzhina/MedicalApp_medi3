package com.hackbright.medi3.services.Impl;


import com.hackbright.medi3.dtos.DoctorDTO;
import com.hackbright.medi3.entities.Doctor;
import com.hackbright.medi3.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements com.hackbright.medi3.services.DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addDoctor(DoctorDTO doctorDto){
        List<String> response = new ArrayList<>();

        Doctor doctor = new Doctor(doctorDto);
        doctorRepository.saveAndFlush(doctor);
        response.add("http://localhost:8080/logindoctor.html");
        return response;
    }

    @Override
    public List<String> doctorLogin(DoctorDTO doctorDto){
        List<String> response = new ArrayList<>();
        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(doctorDto.getEmail());

        System.out.println("\n\n\n in doctor service\n\n\n");

        if (doctorOptional.isPresent()){
            // check to see if the password matches the hash by two conditional statements
            if (passwordEncoder.matches(doctorDto.getPassword(), doctorOptional.get().getPassword())){
                response.add("http://localhost:8080/doctorhome.html");
                response.add(String.valueOf(doctorOptional.get().getId()));
            } else {
                response.add("Doctor email or password incorrect");
            }
        } else {
            response.add("Doctor email or password incorrect");
        }
        return response;
    }
}



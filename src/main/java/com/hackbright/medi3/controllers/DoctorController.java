package com.hackbright.medi3.controllers;


import com.hackbright.medi3.dtos.DoctorDTO;
import com.hackbright.medi3.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public List<String> addDoctor(@RequestBody DoctorDTO doctorDto) {
        String passHash = passwordEncoder.encode(doctorDto.getPassword());
        doctorDto.setPassword(passHash);
        return doctorService.addDoctor(doctorDto);
    }
    @PostMapping("/login")
    public List<String> doctorLogin(@RequestBody DoctorDTO doctorDto){

        return doctorService.doctorLogin(doctorDto);
    }
}
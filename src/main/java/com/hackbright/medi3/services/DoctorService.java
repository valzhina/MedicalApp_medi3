package com.hackbright.medi3.services;

import com.hackbright.medi3.dtos.DoctorDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface DoctorService {
    @Transactional
    List<String> addDoctor(DoctorDTO doctorDto);

    List<String> doctorLogin(DoctorDTO doctorDto);
}

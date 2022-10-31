package com.csm.Dunimed.controller;

import com.csm.Dunimed.DTO.PatientDTORequest;
import com.csm.Dunimed.DTO.PatientDTOResponse;
import com.csm.Dunimed.model.Patient;
import com.csm.Dunimed.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("list")
    public List<PatientDTOResponse> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(PatientDTOResponse::of)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PatientDTOResponse SavePatient(PatientDTORequest request) {
        try {
            return PatientDTOResponse.of(patientRepository.save(Patient.of(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Patient");
        }
    }
}

package com.csm.Dunimed.MedicalCareModule.controller;

import com.csm.Dunimed.MedicalCareModule.DTO.PatientDTORequest;
import com.csm.Dunimed.MedicalCareModule.DTO.PatientDTOResponse;
import com.csm.Dunimed.MedicalCareModule.repository.PatientRepository;
import com.csm.Dunimed.exceptions.NotFoundException;
import com.csm.Dunimed.MedicalCareModule.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("{id}")
    public PatientDTOResponse getPatientByID(@PathVariable Integer id){
        return patientRepository.findById(id)
                .map(PatientDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Patient Not Found"));
    }

    @PostMapping
    public PatientDTOResponse savePatient(@RequestBody PatientDTORequest request) {
        try {
            return PatientDTOResponse.of(patientRepository.save(Patient.of(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Patient");
        }
    }

    @DeleteMapping("{id}")
    public String deletePatient(@PathVariable Integer id){
        try {
            patientRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            throw new PersistenceException("Erro ao deletar o paciente");
        }
    }


}

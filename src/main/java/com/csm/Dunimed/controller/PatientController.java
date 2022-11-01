package com.csm.Dunimed.controller;

import com.csm.Dunimed.DTO.PatientDTORequest;
import com.csm.Dunimed.DTO.PatientDTOResponse;
import com.csm.Dunimed.exceptions.NotFoundException;
import com.csm.Dunimed.model.Patient;
import com.csm.Dunimed.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    @GetMapping("{id}")
    public PatientDTOResponse getPatientByID(@PathVariable Integer id){
        return patientRepository.findById(id)
                .map(PatientDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Não encontrado"));
    }

    @PostMapping
    public PatientDTOResponse SavePatient(@RequestBody PatientDTORequest request) {
        try {
            return PatientDTOResponse.of(patientRepository.save(Patient.of(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Patient");
        }
    }

    @PostMapping("{id}")
    public String deletePatient(@PathVariable Integer id){
        try {
            patientRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            throw new PersistenceException("Erro ao deletar o paciente");
        }
    }


}

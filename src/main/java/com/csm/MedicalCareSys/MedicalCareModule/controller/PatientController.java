package com.csm.MedicalCareSys.MedicalCareModule.controller;

import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.PatientDTORequest;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.PatientDTOResponse;
import com.csm.MedicalCareSys.MedicalCareModule.repository.PatientRepository;
import com.csm.MedicalCareSys.MedicalCareModule.model.Patient;
import com.csm.MedicalCareSys.MedicalCareModule.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @GetMapping("list")
    public List<PatientDTOResponse> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(PatientDTOResponse::of)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public PatientDTOResponse getPatientByID(@PathVariable UUID id){
        return patientRepository.findById(id)
                .map(PatientDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Patient Not Found"));
    }

    @PostMapping
    public PatientDTOResponse savePatient(@RequestBody PatientDTORequest request) {
        try {
            Patient toSave = patientService.populate(request);
            return PatientDTOResponse.of(patientRepository.save(toSave));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Patient");
        }
    }

    @PutMapping
    public PatientDTOResponse updatePatient(@RequestBody PatientDTORequest request) {
        try {
            Patient toSave = patientService.populate(request);
            return PatientDTOResponse.of(patientRepository.save(toSave));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Patient");
        }
    }

    @DeleteMapping("{id}")
    public String deletePatient(@PathVariable UUID id){
        try {
            patientRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            throw new PersistenceException("Erro ao deletar o paciente");
        }
    }


}

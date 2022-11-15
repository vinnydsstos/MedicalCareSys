package com.csm.MedicalCareSys.MedicalCareModule.controller;

import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.DoctorDTORequest;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.DoctorDTOResponse;
import com.csm.MedicalCareSys.MedicalCareModule.model.Doctor;
import com.csm.MedicalCareSys.MedicalCareModule.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("list")
    public List<DoctorDTOResponse> getAllDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(DoctorDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public DoctorDTOResponse getDoctorById(@PathVariable Integer id){
        return doctorRepository.findById(id)
                .map(DoctorDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Não encontrado"));
    }

    @PostMapping
    public DoctorDTOResponse SaveDoctor(@RequestBody DoctorDTORequest request) {
        try {
            return DoctorDTOResponse.of(doctorRepository.save(Doctor.of(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Doctor");
        }
    }

    @DeleteMapping("{id}")
    public String deleteDoctor(@PathVariable Integer id){
        try {

            doctorRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            throw new PersistenceException("Erro ao deletar o paciente");
        }
    }

}

package com.csm.MedicalCareSys.MedicalCareModule.controller;

import com.csm.MedicalCareSys.MedicalCareModule.DTO.MedicalAppointmentDTORequest;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.MedicalAppointmentDTOResponse;
import com.csm.MedicalCareSys.MedicalCareModule.model.MedicalAppointment;
import com.csm.MedicalCareSys.MedicalCareModule.repository.PatientRepository;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareSys.MedicalCareModule.repository.DoctorRepository;
import com.csm.MedicalCareSys.MedicalCareModule.repository.MedicalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("appointment")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("list")
    public List<MedicalAppointmentDTOResponse> getAllMedicalAppointment(){
        return appointmentRepository.findAll()
                .stream()
                .map(MedicalAppointmentDTOResponse::of)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MedicalAppointmentDTOResponse getMedicalAppointmentByID(@PathVariable UUID id){
        return appointmentRepository.findById(id)
                .map(MedicalAppointmentDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Não encontrado"));
    }


    @PostMapping
    public MedicalAppointmentDTOResponse SaveMedicalAppointment(@RequestBody MedicalAppointmentDTORequest request) {
        try {
            MedicalAppointment ma = MedicalAppointment.of(request);
            ma.setDoctor(doctorRepository.findById(request.getDoctor())
                    .orElseThrow(() -> new NotFoundException("Doctor Not Found")));
             ma.setPatient(patientRepository.findById(request.getPatient())
                    .orElseThrow(()-> new NotFoundException("Patient Not Found")));
            return MedicalAppointmentDTOResponse
                    .of(appointmentRepository
                            .save(ma));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Medical Appointment");
        }
    }


    @DeleteMapping("{id}")
    public String deleteMedicalAppointment(@PathVariable UUID id){
        try {
            appointmentRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Error deleting the medical appointment");

        }
    }
}

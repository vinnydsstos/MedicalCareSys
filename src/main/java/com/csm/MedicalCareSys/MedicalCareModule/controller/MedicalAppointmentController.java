package com.csm.MedicalCareSys.MedicalCareModule.controller;

import com.csm.MedicalCareSys.MedicalCareModule.DTO.MedicalAppointmentDTORequest;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.MedicalAppointmentDTOResponse;
import com.csm.MedicalCareSys.MedicalCareModule.model.MedicalAppointment;
import com.csm.MedicalCareSys.MedicalCareModule.repository.PatientRepository;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareSys.MedicalCareModule.repository.DoctorRepository;
import com.csm.MedicalCareSys.MedicalCareModule.repository.MedicalAppointmentRepository;
import com.csm.MedicalCareSys.MedicalCareModule.service.MedicalAppointmentService;
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
    private MedicalAppointmentService medicalAppointmentService;

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
                .orElseThrow(() -> new NotFoundException("Not found"));
    }


    @PostMapping
    public MedicalAppointmentDTOResponse SaveMedicalAppointment(@RequestBody MedicalAppointmentDTORequest request) {
        try {
            MedicalAppointment appointment = medicalAppointmentService.populate(request);
            return MedicalAppointmentDTOResponse
                    .of(appointmentRepository
                            .save(appointment));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Medical Appointment");
        }
    }


    @DeleteMapping("{id}")
    public String deleteMedicalAppointment(@PathVariable(value = "id") UUID id){
        try {
            appointmentRepository.deleteById(id);
            return "Success";
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Error deleting the medical appointment");

        }
    }
}

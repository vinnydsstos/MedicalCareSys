package com.csm.Dunimed.controller;

import com.csm.Dunimed.DTO.MedicalAppointmentDTORequest;
import com.csm.Dunimed.DTO.MedicalAppointmentDTOResponse;
import com.csm.Dunimed.DTO.PatientDTORequest;
import com.csm.Dunimed.DTO.PatientDTOResponse;
import com.csm.Dunimed.exceptions.NotFoundException;
import com.csm.Dunimed.model.MedicalAppointment;
import com.csm.Dunimed.model.Patient;
import com.csm.Dunimed.repository.DoctorRepository;
import com.csm.Dunimed.repository.MedicalAppointmentRepository;
import com.csm.Dunimed.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
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
    public MedicalAppointmentDTOResponse getMedicalAppointmentByID(@PathVariable Integer id){
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
    public String deleteMedicalAppointment(@PathVariable Integer id){
        try {
            appointmentRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Erro ao deletar o paciente");

        }
    }
}

package com.csm.Dunimed.MedicalCareModule.controller;

import com.csm.Dunimed.MedicalCareModule.DTO.ExaminationDTORequest;
import com.csm.Dunimed.MedicalCareModule.DTO.ExaminationDTOResponse;
import com.csm.Dunimed.MedicalCareModule.model.Examination;
import com.csm.Dunimed.exceptions.NotFoundException;
import com.csm.Dunimed.MedicalCareModule.repository.ExaminationRepository;
import com.csm.Dunimed.MedicalCareModule.repository.MedicalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("examination")
public class ExaminationController {


    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private MedicalAppointmentRepository appointmentRepository;

    @GetMapping("list")
    public List<ExaminationDTOResponse> getAllExamination(){
        return examinationRepository.findAll()
                .stream()
                .map(ExaminationDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public ExaminationDTOResponse getExaminationById(@PathVariable Integer id){
        return examinationRepository.findById(id)
                .map(ExaminationDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Não encontrado"));
    }

    @PostMapping
    public ExaminationDTOResponse SaveExamination(@RequestBody ExaminationDTORequest request) {
        try {
            Examination ex = Examination.of(request);
            ex.setMedicalAppointment(
                    appointmentRepository.findById(request.getMedicalAppointmentId())
                            .orElseThrow( ()-> new NotFoundException("Medical Appointment Not Found")));
            return ExaminationDTOResponse.of(examinationRepository.save(ex));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Examination");
        }
    }

    @DeleteMapping("{id}")
    public String deleteExamination(@PathVariable Integer id){
        try {

            examinationRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Error deleting the examination");
        }
    }




}

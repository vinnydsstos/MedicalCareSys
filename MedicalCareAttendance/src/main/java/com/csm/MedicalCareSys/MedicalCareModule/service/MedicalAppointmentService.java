package com.csm.MedicalCareSys.MedicalCareModule.service;

import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.MedicalAppointmentDTORequest;
import com.csm.MedicalCareSys.MedicalCareModule.model.MedicalAppointment;
import com.csm.MedicalCareSys.MedicalCareModule.repository.DoctorRepository;
import com.csm.MedicalCareSys.MedicalCareModule.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalAppointmentService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public MedicalAppointment populate(MedicalAppointmentDTORequest request) {
        MedicalAppointment toReturn = MedicalAppointment.of(request);
        toReturn.setDoctor(doctorRepository.findById(request.getDoctor())
                .orElseThrow(() -> new NotFoundException("Doctor Not Found")));
        toReturn.setPatient(patientRepository.findById(request.getPatient())
                .orElseThrow(()-> new NotFoundException("Patient Not Found")));
        return toReturn;
    }
}

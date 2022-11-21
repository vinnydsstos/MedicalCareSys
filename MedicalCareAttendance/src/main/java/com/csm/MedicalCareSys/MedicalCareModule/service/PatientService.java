package com.csm.MedicalCareSys.MedicalCareModule.service;

import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.PatientDTORequest;
import com.csm.MedicalCareSys.MedicalCareModule.model.Address;
import com.csm.MedicalCareSys.MedicalCareModule.model.Patient;
import com.csm.MedicalCareSys.MedicalCareModule.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private AddressRepository addressRepository;

    public Patient populate(PatientDTORequest request) {
        Address address = addressRepository.findById(request.getAddress())
                .orElseThrow(()-> new NotFoundException("Address not found"));
        return Patient.of(request, address);
    }
}

package com.csm.MedicalCareSys.MedicalCareModule.controller;

import com.csm.MedicalCareSys.MedicalCareModule.DTO.AddressDTORequest;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.PatientDTORequest;
import com.csm.MedicalCareSys.MedicalCareModule.DTO.PatientDTOResponse;
import com.csm.MedicalCareSys.MedicalCareModule.model.Address;
import com.csm.MedicalCareSys.MedicalCareModule.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientControllerTest {

    @Mock
    PatientController patientController;

    PatientDTORequest p;



    @BeforeEach
    public void init(){
        // arrange
        p = PatientDTORequest.builder()
                .name("Vinicius dos Santos")
                .email("vinicius@gmail.com")
                .phone("31853185318")
                .gender("male")
                .address(AddressDTORequest.builder()
                        .country("brazil")
                        .state("São Paulo")
                        .city("City")
                        .street("Street")
                        .number(123)
                        .complement("House")
                        .build())
                .build();

    }


    @Test
    @DisplayName("Should Save the patient successfully")
    void savePatient() {

        Mockito.when(patientController
                .savePatient(p))
                .thenReturn(PatientDTOResponse.of(Patient.of(p)));

        patientController.savePatient(p);

        // assertions

        Mockito.verify(patientController).savePatient(p);

    }
}
package com.csm.MedicalCareSys.MedicalCareModule.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PatientDTORequest implements Serializable {
    private final Integer id;
    private final String name;
    private final String gender;
    private final String email;
    private final String phone;
    private final AddressDTORequest address;


}
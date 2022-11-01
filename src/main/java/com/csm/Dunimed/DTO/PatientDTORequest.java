package com.csm.Dunimed.DTO;

import com.csm.Dunimed.model.Patient;
import lombok.Data;

import java.io.Serializable;

@Data
public class PatientDTORequest implements Serializable {
    private final Integer id;
    private final String name;
    private final String gender;
    private final String email;
    private final String phone;
    private final AddressDTORequest address;


}
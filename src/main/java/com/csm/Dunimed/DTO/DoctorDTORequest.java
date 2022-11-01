package com.csm.Dunimed.DTO;

import com.csm.Dunimed.model.Address;
import lombok.Data;

import java.io.Serializable;


@Data
public class DoctorDTORequest implements Serializable {
    private final Integer id;
    private final String name;
    private final String gender;
    private final String email;
    private final String phone;
    private final String medicalSpecialty;
    private final Boolean isSurgeon;

}
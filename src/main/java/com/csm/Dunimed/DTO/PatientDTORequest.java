package com.csm.Dunimed.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatientDTORequest implements Serializable {
    private final Integer id;
    private final String nome;
    private final String gender;
    private final String email;
    private final String phone;
}
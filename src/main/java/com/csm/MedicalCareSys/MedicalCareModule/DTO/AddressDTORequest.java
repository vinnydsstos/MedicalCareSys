package com.csm.MedicalCareSys.MedicalCareModule.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class AddressDTORequest implements Serializable {
    private final Integer id;
    private final String country;
    private final String state;
    private final String city;
    private final String street;
    private final Integer number;
    private final String complement;
}
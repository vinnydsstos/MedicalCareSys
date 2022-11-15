package com.csm.MedicalCareSys.SalesModule.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Insurance} entity
 */
@Data
public class InsuranceDTORequest implements Serializable {
    private final Integer id;
    private final String coverage;
    private final Double monthValue;
    private final Boolean status;
}
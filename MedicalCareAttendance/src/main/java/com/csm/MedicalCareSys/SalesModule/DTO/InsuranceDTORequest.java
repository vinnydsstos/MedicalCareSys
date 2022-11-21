package com.csm.MedicalCareSys.SalesModule.DTO;

import com.csm.MedicalCareSys.SalesModule.ENUM.Coverage;
import com.csm.MedicalCareSys.SalesModule.ENUM.InsuranceStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Insurance} entity
 */
@Data
public class InsuranceDTORequest implements Serializable {
    private final UUID id;
    private final String coverage;
    private final Double monthValue;
    private final String status;
    private final UUID order;
}
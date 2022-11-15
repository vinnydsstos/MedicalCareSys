package com.csm.MedicalCareSys.SalesModule.DTO;

import com.csm.MedicalCareSys.SalesModule.model.Insurance;
import com.csm.MedicalCareSys.SalesModule.model.Seller;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Insurance} entity
 */
@Data
@Builder
public class InsuranceDTOResponse implements Serializable {
    private final Integer id;
    private final String coverage;
    private final Double monthValue;
    private final Boolean status;

    public static InsuranceDTOResponse of(Insurance d){
        return InsuranceDTOResponse.builder()
                .id(d.getId())
                .coverage(d.getCoverage())
                .monthValue(d.getMonthValue())
                .status(d.getStatus())
                .build();
    }
}
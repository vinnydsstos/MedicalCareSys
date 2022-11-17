package com.csm.MedicalCareSys.SalesModule.DTO;

import com.csm.MedicalCareSys.MedicalCareModule.DTO.PatientDTOResponse;
import com.csm.MedicalCareSys.MedicalCareModule.model.Patient;
import com.csm.MedicalCareSys.SalesModule.model.Insurance;
import com.csm.MedicalCareSys.SalesModule.model.Order;
import com.csm.MedicalCareSys.SalesModule.model.Seller;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Order} entity
 */
@Data
@Builder
public class OrderDTOResponse implements Serializable {
    private final UUID id;
    private final PatientDTOResponse patient;
    private final SellerDTOResponse seller;
    private final LocalDate saleDate;

    public static OrderDTOResponse of(Order d){
        return OrderDTOResponse.builder()
                .id(d.getId())
                .saleDate(d.getSaleDate())
                .patient(PatientDTOResponse.of(d.getPatient()))
                .seller(SellerDTOResponse.of(d.getSeller()))
                .build();
    }
}
package com.csm.MedicalCareSys.SalesModule.DTO;

import com.csm.MedicalCareSys.SalesModule.model.Insurance;
import com.csm.MedicalCareSys.SalesModule.model.Order;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Order} entity
 */
@Data
@Builder
public class OrderDTOResponse implements Serializable {
    private final Integer id;
    private final LocalDate saleDate;

    public static OrderDTOResponse of(Order d){
        return OrderDTOResponse.builder()
                .id(d.getId())
                .saleDate(d.getSaleDate())
                .build();
    }
}
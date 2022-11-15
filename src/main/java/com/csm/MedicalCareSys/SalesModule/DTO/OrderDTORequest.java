package com.csm.MedicalCareSys.SalesModule.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Order} entity
 */
@Data
public class OrderDTORequest implements Serializable {
    private final Integer id;
    private final LocalDate saleDate;
    private final Integer patient;
    private final Integer seller;
    private final Integer insurance;
    private final String channel;
}
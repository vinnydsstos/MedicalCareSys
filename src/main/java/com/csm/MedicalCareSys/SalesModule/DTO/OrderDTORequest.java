package com.csm.MedicalCareSys.SalesModule.DTO;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Order} entity
 */
@Data
public class OrderDTORequest implements Serializable {
    private final UUID id;
    private final LocalDate saleDate;
    private final UUID patient;
    private final UUID seller;
    private final UUID insurance;
    private final String channel;
}
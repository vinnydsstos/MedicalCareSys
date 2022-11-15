package com.csm.MedicalCareSys.SalesModule.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Channel} entity
 */
@Data
public class ChannelDTORequest implements Serializable {
    private final UUID id;
    private final String type;
}
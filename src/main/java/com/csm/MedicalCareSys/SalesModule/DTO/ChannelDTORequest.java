package com.csm.MedicalCareSys.SalesModule.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Channel} entity
 */
@Data
public class ChannelDTORequest implements Serializable {
    private final Integer id;
    private final String type;
}
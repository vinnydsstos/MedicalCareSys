package com.csm.Dunimed.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.csm.Dunimed.model.Examination} entity
 */
@Data
public class ExaminationDTORequest implements Serializable {
    private final Integer id;
    private final String name;
    private final Date examDate;
    private final String technician;

}
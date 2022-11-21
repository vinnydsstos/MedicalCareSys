package com.csm.MedicalCareSys.MedicalCareModule.DTO;

import com.csm.MedicalCareSys.MedicalCareModule.model.Examination;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * A DTO for the {@link Examination} entity
 */
@Data
public class ExaminationDTORequest implements Serializable {
    private final UUID id;
    private final String name;
    private final LocalDate examDate;
    private final String technician;
    private final UUID medicalAppointmentId;

}
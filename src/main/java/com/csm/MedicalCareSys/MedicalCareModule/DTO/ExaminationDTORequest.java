package com.csm.MedicalCareSys.MedicalCareModule.DTO;

import com.csm.MedicalCareSys.MedicalCareModule.model.Examination;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A DTO for the {@link Examination} entity
 */
@Data
public class ExaminationDTORequest implements Serializable {
    private final Integer id;
    private final String name;
    private final LocalDate examDate;
    private final String technician;
    private final Integer medicalAppointmentId;

}
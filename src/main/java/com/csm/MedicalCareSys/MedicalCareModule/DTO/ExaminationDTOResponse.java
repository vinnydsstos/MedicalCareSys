package com.csm.MedicalCareSys.MedicalCareModule.DTO;

import com.csm.MedicalCareSys.MedicalCareModule.model.Examination;
import com.csm.MedicalCareSys.MedicalCareModule.model.Examination;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A DTO for the {@link Examination} entity
 */
@Data
@Builder
public class ExaminationDTOResponse implements Serializable {
    private final Integer id;
    private final String name;
    private final LocalDate examDate;
    private final String technician;
    private final MedicalAppointmentDTOResponse medicalAppointment;

    public static ExaminationDTOResponse of(Examination d){
        return ExaminationDTOResponse.builder()
                .id(d.getId())
                .name(d.getName())
                .examDate(d.getExamDate())
                .technician(d.getTechnician())
                .medicalAppointment(MedicalAppointmentDTOResponse.of(d.getMedicalAppointment()))
                .build();
    }

}
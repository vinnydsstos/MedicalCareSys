package com.csm.Dunimed.DTO;

import com.csm.Dunimed.model.Examination;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.csm.Dunimed.model.Examination} entity
 */
@Data
@Builder
public class ExaminationDTOResponse implements Serializable {
    private final Integer id;
    private final String name;
    private final Date examDate;
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
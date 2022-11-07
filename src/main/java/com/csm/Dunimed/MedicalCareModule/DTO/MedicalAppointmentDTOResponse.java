package com.csm.Dunimed.MedicalCareModule.DTO;

import com.csm.Dunimed.MedicalCareModule.model.MedicalAppointment;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A DTO for the {@link MedicalAppointment} entity
 */
@Data
@Builder
public class MedicalAppointmentDTOResponse implements Serializable {
    private final Integer id;
    private final String status;
    private final String location;
    private final LocalDate appointmentDate;
    private final LocalDate returnDate;
    private final PatientDTOResponse patient;
    private final DoctorDTOResponse doctor;


    public static MedicalAppointmentDTOResponse of (MedicalAppointment d){
        return MedicalAppointmentDTOResponse.builder()
                .id(d.getId())
                .status(d.getStatus())
                .location(d.getLocation())
                .appointmentDate(d.getAppointmentDate())
                .returnDate(d.getReturnDate())
                .patient(PatientDTOResponse.of(d.getPatient()))
                .doctor(DoctorDTOResponse.of(d.getDoctor()))
                .build();
    }

}
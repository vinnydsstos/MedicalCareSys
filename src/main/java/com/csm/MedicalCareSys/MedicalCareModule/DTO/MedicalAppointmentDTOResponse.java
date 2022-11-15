package com.csm.MedicalCareSys.MedicalCareModule.DTO;

import com.csm.MedicalCareSys.MedicalCareModule.model.MedicalAppointment;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * A DTO for the {@link MedicalAppointment} entity
 */
@Data
@Builder
public class MedicalAppointmentDTOResponse implements Serializable {
    private final UUID id;
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
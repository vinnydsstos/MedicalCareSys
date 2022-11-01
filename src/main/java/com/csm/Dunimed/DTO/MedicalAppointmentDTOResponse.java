package com.csm.Dunimed.DTO;

import com.csm.Dunimed.model.MedicalAppointment;
import com.csm.Dunimed.model.Patient;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.csm.Dunimed.model.MedicalAppointment} entity
 */
@Data
@Builder
public class MedicalAppointmentDTOResponse implements Serializable {
    private final Integer id;
    private final String status;
    private final String location;
    private final Date appointmentDate;
    private final Date returnDate;
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
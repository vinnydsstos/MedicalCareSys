package com.csm.Dunimed.MedicalCareModule.DTO;

import com.csm.Dunimed.MedicalCareModule.model.MedicalAppointment;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A DTO for the {@link MedicalAppointment} entity
 */
@Data
public class MedicalAppointmentDTORequest implements Serializable {
    private final Integer id;
    private final String status;
    private final String location;
    private final LocalDate appointmentDate;
    private final LocalDate returnDate;
    private final Integer patient;
    private final Integer doctor;

}
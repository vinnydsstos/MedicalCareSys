package com.csm.Dunimed.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.csm.Dunimed.model.MedicalAppointment} entity
 */
@Data
public class MedicalAppointmentDTORequest implements Serializable {
    private final Integer id;
    private final String status;
    private final String location;
    private final Date appointmentDate;
    private final Date returnDate;
    private final Integer patient;
    private final Integer doctor;

}
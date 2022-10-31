package com.csm.Dunimed.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MEDICALAPPOINTMENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAppointment
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="STATUS")
    private String status;

    @Column(name="LOCATION")
    private String location;

    @Column(name="APPOINTMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;

    @Column(name="RETURN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_PATIENT", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_PATIENT_MEDICAL_APPOINTMENT"))
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_DOCTOR", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_DOCTOR_MEDICAL_APPOINTMENT"))
    private Doctor doctor;

    @OneToMany(mappedBy = "medicalAppointment")
    private List<Examination> examinations;


}

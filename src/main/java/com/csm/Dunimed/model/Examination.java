package com.csm.Dunimed.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EXAMINATION")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EXAM_DATE")
    private Date examDate;

    @Column(name="TECHNICIAN")
    private String technician;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "FK_EXAMINATION", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_EXAMINATION"))
    private MedicalAppointment medicalAppointment;




}

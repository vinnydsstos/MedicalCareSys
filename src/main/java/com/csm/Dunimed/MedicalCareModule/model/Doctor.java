package com.csm.Dunimed.MedicalCareModule.model;

import com.csm.Dunimed.MedicalCareModule.DTO.DoctorDTORequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DOCTOR")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="GENDER")
    private String gender;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @Column(name="MEDICAL")
    private String medicalSpecialty;

    @Column(name="ISSURGEON")
    private Boolean isSurgeon;




    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<MedicalAppointment> medicalAppointments;

    public static Doctor of(DoctorDTORequest d) {
       return Doctor.builder()
                .id(d.getId())
                .name(d.getName())
                .email(d.getEmail())
                .gender(d.getGender())
                .phone(d.getPhone())
                .medicalSpecialty(d.getMedicalSpecialty())
                .isSurgeon(d.getIsSurgeon())
                .build();
    }
}

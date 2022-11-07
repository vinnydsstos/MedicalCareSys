package com.csm.Dunimed.MedicalCareModule.model;

import com.csm.Dunimed.MedicalCareModule.DTO.PatientDTORequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="PATIENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FK_ADDRESS", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_PATIENT_ADDRESS"))
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    List<MedicalAppointment> medicalAppointments;

    public static Patient of(PatientDTORequest p){
        return Patient.builder()
                .id(p.getId())
                .name(p.getName())
                .email(p.getEmail())
                .phone(p.getPhone())
                .gender(p.getGender())
                .address(Address.of(p.getAddress()))
                .build();
    }

}

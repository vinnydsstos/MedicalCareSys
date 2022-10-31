package com.csm.Dunimed.model;

import com.csm.Dunimed.DTO.PatientDTORequest;
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

    @Column(name="nome")
    private String nome;

    @Column(name="gender")
    private String gender;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "FK_ADDRESS", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_PATIENT_ADDRESS"))

    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    List<MedicalAppointment> medicalAppointments;

    public static Patient of(PatientDTORequest p){
        return Patient.builder()
                .id(p.getId())
                .nome(p.getNome())
                .email(p.getEmail())
                .phone(p.getPhone())
                .gender(p.getGender())
                .build();
    }

}

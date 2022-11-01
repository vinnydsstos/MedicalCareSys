package com.csm.Dunimed.DTO;

import com.csm.Dunimed.model.Doctor;
import com.csm.Dunimed.model.Patient;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class DoctorDTOResponse implements Serializable {
    private final Integer id;
    private final String name;
    private final String gender;
    private final String email;
    private final String phone;
    private final String medicalSpecialty;
    private final Boolean isSurgeon;

    public static DoctorDTOResponse of(Doctor d){
        return DoctorDTOResponse.builder()
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
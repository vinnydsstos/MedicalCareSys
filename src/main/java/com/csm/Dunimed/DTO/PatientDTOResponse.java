package com.csm.Dunimed.DTO;

import com.csm.Dunimed.model.Patient;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PatientDTOResponse implements Serializable {
    private final Integer id;
    private final String nome;
    private final String gender;
    private final String email;
    private final String phone;
    private final AddressDTOResponse address;

    public static PatientDTOResponse of(Patient p){
        return PatientDTOResponse.builder()
                .id(p.getId())
                .nome(p.getName())
                .email(p.getEmail())
                .gender(p.getGender())
                .phone(p.getPhone())
                .address(AddressDTOResponse.of(p.getAddress()))
                .build();
    }
}
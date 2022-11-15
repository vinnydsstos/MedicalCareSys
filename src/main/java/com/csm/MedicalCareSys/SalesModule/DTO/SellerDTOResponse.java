package com.csm.MedicalCareSys.SalesModule.DTO;

import com.csm.MedicalCareSys.SalesModule.model.Seller;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.csm.MedicalCareSys.SalesModule.model.Seller} entity
 */
@Data
@Builder
public class SellerDTOResponse implements Serializable {
    private final Integer id;
    private final String username;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;

    public static SellerDTOResponse of(Seller d){
        return SellerDTOResponse.builder()
                .id(d.getId())
                .username(d.getUsername())
                .password(d.getPassword())
                .name(d.getName())
                .email(d.getEmail())
                .phone(d.getPhone())
                .build();
    }
}
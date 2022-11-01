package com.csm.Dunimed.DTO;

import com.csm.Dunimed.model.Address;
import com.csm.Dunimed.model.Patient;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class AddressDTOResponse implements Serializable {
    private final Integer id;
    private final String country;
    private final String state;
    private final String city;
    private final String street;
    private final Integer number;
    private final String complement;

    public static AddressDTOResponse of(Address p){
        return AddressDTOResponse.builder()
                .id(p.getId())
                .city(p.getCity())
                .country(p.getCountry())
                .complement(p.getComplement())
                .number(p.getNumber())
                .state(p.getState())
                .street(p.getStreet())
                .build();
    }
}
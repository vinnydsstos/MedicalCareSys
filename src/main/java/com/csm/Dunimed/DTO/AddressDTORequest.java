package com.csm.Dunimed.DTO;

import lombok.Data;

import java.io.Serializable;


@Data
public class AddressDTORequest implements Serializable {
    private final Integer id;
    private final String country;
    private final String state;
    private final String city;
    private final String street;
    private final Integer number;
    private final String complement;
}
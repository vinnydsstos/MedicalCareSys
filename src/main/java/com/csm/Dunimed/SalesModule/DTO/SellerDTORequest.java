package com.csm.Dunimed.SalesModule.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.csm.Dunimed.SalesModule.model.Seller} entity
 */
@Data
public class SellerDTORequest implements Serializable {
    private final Integer id;
    private final String username;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;
}
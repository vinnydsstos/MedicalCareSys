package com.csm.MedicalCareSys.SalesModule.model;

import com.csm.MedicalCareSys.SalesModule.DTO.SellerDTORequest;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "SELLER")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seller {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @OneToMany(mappedBy = "seller")
    private List<Order> orders;


    public static Seller of(SellerDTORequest s){
        return Seller.builder()
                .id(s.getId())
                .name(s.getName())
                .email(s.getEmail())
                .phone(s.getPhone())
                .build();
    }





}
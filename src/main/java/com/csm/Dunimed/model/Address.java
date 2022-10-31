package com.csm.Dunimed.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(name="ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="STATE")
    private String state;

    @Column(name="CITY")
    private String city;

    @Column(name="STREET")
    private String street;

    @Column(name="NUMBER")
    private Integer number;

    @Column(name="COMPLEMENT")
    private String complement;


}

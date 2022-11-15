package com.csm.MedicalCareSys.SalesModule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CHANNEL")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Channel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TYPE")
    private String type;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    private List<Order> orders;

}
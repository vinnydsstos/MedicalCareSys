package com.csm.MedicalCareSys.SalesModule.model;

import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTORequest;
import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTOResponse;
import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTORequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "SELLER")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="COVERAGE")
    private String coverage;

    @Column(name="MONTH_VALUE")
    private Double monthValue;

    @Column(name="STATUS")
    private Boolean status;

    public static Insurance of (InsuranceDTORequest d){
        return Insurance.builder()
                .id(d.getId())
                .coverage(d.getCoverage())
                .monthValue(d.getMonthValue())
                .status(d.getStatus())
                .build();
    }




}
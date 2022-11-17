package com.csm.MedicalCareSys.SalesModule.model;

import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTORequest;
import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTOResponse;
import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTORequest;
import com.csm.MedicalCareSys.SalesModule.ENUM.Coverage;
import com.csm.MedicalCareSys.SalesModule.ENUM.InsuranceStatus;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "INSURANCE")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "COVERAGE")
    private Coverage coverage;

    @Column(name = "MONTH_VALUE")
    private Double monthValue;

    @Column(name = "STATUS")
    private InsuranceStatus status;

    public static Insurance of(InsuranceDTORequest d) {
        return Insurance.builder()
                .id(d.getId())
                .coverage(Coverage.valueOf(d.getCoverage()))
                .monthValue(d.getMonthValue())
                .status(InsuranceStatus.valueOf(d.getStatus()))
                .build();
    }


}
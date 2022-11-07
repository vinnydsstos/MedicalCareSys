package com.csm.Dunimed.SalesModule.model;

import com.csm.Dunimed.MedicalCareModule.model.Patient;
import com.csm.Dunimed.SalesModule.DTO.OrderDTORequest;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SALE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate saleDate;

    @OneToOne
    @JoinColumn(name = "FK_PATIENT", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_PATIENT"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "FK_CHANNEL", referencedColumnName = "ID",
    foreignKey = @ForeignKey(name = "FK_CHANNEL"))
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "FK_SELLER", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_SELLER"))
    private Seller seller;


    @Nullable
    @OneToOne
    @JoinColumn(name = "FK_INSURANCE", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_INSURANCE"), nullable = true)
    private Insurance insurance;

    public static Order of (OrderDTORequest d){
        return Order.builder()
                .id(d.getId())
                .saleDate(d.getSaleDate())
                .patient(Patient.builder().id(d.getPatient()).build())
                .channel(Channel.builder().type(d.getChannel()).build())
                .seller(Seller.builder().id(d.getSeller()).build())
                .insurance(Insurance.builder().id(d.getInsurance()).build())
                .build();
    }


}
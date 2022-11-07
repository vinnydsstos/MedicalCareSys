package com.csm.Dunimed.SalesModule.service;

import com.csm.Dunimed.MedicalCareModule.model.Patient;
import com.csm.Dunimed.MedicalCareModule.repository.PatientRepository;
import com.csm.Dunimed.SalesModule.DTO.OrderDTORequest;
import com.csm.Dunimed.SalesModule.model.Channel;
import com.csm.Dunimed.SalesModule.model.Insurance;
import com.csm.Dunimed.SalesModule.model.Order;
import com.csm.Dunimed.SalesModule.model.Seller;
import com.csm.Dunimed.SalesModule.repository.ChannelRepository;
import com.csm.Dunimed.SalesModule.repository.InsuranceRepository;
import com.csm.Dunimed.SalesModule.repository.SellerRepository;
import com.csm.Dunimed.exceptions.NotFoundException;
import com.csm.Dunimed.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Order processDataToPersist(OrderDTORequest request){

        Optional<Channel> c = channelRepository.findByType(request.getChannel());
        Optional<Seller> s = sellerRepository.findById(request.getSeller());
        Optional<Patient> p = patientRepository.findById(request.getPatient());

        return Order.builder()
                .id(request.getId())
                .saleDate(request.getSaleDate())
                .channel(c.orElseThrow( () -> new PersistenceException("Channel Not Found")))
                .seller(s.orElseThrow( () -> new PersistenceException("Seller Not Found")))
                .patient(p.orElseThrow( () -> new PersistenceException("Patient Not Found")))
                .build();
    }
}

package com.csm.MedicalCareSys.SalesModule.service;

import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTORequest;
import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTOResponse;
import com.csm.MedicalCareSys.SalesModule.model.Insurance;
import com.csm.MedicalCareSys.SalesModule.model.Order;
import com.csm.MedicalCareSys.SalesModule.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InsuranceService {

    @Autowired
    private OrderRepository orderRepository;


    public void relateOrderToInsurance(InsuranceDTORequest insuranceResponse, Insurance insurance) {
        Optional<Order> order = orderRepository.findById(insuranceResponse.getOrder());
        order.ifPresent(o -> {
            o.setInsurance(insurance);
            orderRepository.save(o);
        });
    }
}

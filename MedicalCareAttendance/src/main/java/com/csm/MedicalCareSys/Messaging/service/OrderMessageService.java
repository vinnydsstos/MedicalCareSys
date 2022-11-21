package com.csm.MedicalCareSys.Messaging.service;

import com.csm.MedicalCareSys.Messaging.QueueConfigurationParameters;
import com.csm.MedicalCareSys.SalesModule.DTO.OrderDTOResponse;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(OrderDTOResponse order) {
        System.out.println("Mensagem enviada!");
        rabbitTemplate.convertAndSend(QueueConfigurationParameters.ORDERS, order);
    }
}
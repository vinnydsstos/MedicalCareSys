package com.csm.MedicalCareSys.SalesModule.controller;

import com.csm.MedicalCareSys.SalesModule.DTO.OrderDTORequest;
import com.csm.MedicalCareSys.SalesModule.DTO.OrderDTOResponse;
import com.csm.MedicalCareSys.SalesModule.DTO.SellerDTORequest;
import com.csm.MedicalCareSys.SalesModule.DTO.SellerDTOResponse;
import com.csm.MedicalCareSys.SalesModule.model.Order;
import com.csm.MedicalCareSys.SalesModule.model.Seller;
import com.csm.MedicalCareSys.SalesModule.repository.OrderRepository;
import com.csm.MedicalCareSys.SalesModule.repository.SellerRepository;
import com.csm.MedicalCareSys.SalesModule.service.OrderService;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("list")
    public List<OrderDTOResponse> getAllOrders(){
        return orderRepository.findAll()
                .stream()
                .map(OrderDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public OrderDTOResponse getOrderById(@PathVariable Integer id){
        return orderRepository.findById(id)
                .map(OrderDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Seller Not Found"));
    }

    @PostMapping
    public OrderDTOResponse SaveOrder(@RequestBody OrderDTORequest request) {
        try {
            return OrderDTOResponse.of(
                    orderRepository.save(
                            orderService.processDataToPersist(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Order");
        }
    }

    @DeleteMapping("{id}")
    public String deleteOrder(@PathVariable Integer id){
        try {
            orderRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            throw new PersistenceException("Error deleting Seller");
        }
    }

}

package com.csm.Dunimed.SalesModule.controller;

import com.csm.Dunimed.SalesModule.DTO.InsuranceDTORequest;
import com.csm.Dunimed.SalesModule.DTO.InsuranceDTOResponse;
import com.csm.Dunimed.SalesModule.DTO.SellerDTORequest;
import com.csm.Dunimed.SalesModule.DTO.SellerDTOResponse;
import com.csm.Dunimed.SalesModule.model.Insurance;
import com.csm.Dunimed.SalesModule.model.Seller;
import com.csm.Dunimed.SalesModule.repository.InsuranceRepository;
import com.csm.Dunimed.SalesModule.repository.SellerRepository;
import com.csm.Dunimed.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("insurance")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping("list")
    public List<InsuranceDTOResponse> getAllInsurances(){
        return insuranceRepository.findAll()
                .stream()
                .map(InsuranceDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public InsuranceDTOResponse getInsuranceById(@PathVariable Integer id){
        return insuranceRepository.findById(id)
                .map(InsuranceDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Seller Not Found"));
    }

    @PostMapping
    public InsuranceDTOResponse SaveInsurance(@RequestBody InsuranceDTORequest request) {
        try {
            return InsuranceDTOResponse.of(insuranceRepository.save(Insurance.of(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Seller");
        }
    }

    @DeleteMapping("{id}")
    public String deleteInsurance(@PathVariable Integer id){
        try {

            insuranceRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            throw new PersistenceException("Error deleting Seller");
        }
    }

}

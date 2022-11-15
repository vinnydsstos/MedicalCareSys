package com.csm.MedicalCareSys.SalesModule.controller;

import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTORequest;
import com.csm.MedicalCareSys.SalesModule.DTO.InsuranceDTOResponse;
import com.csm.MedicalCareSys.SalesModule.DTO.SellerDTORequest;
import com.csm.MedicalCareSys.SalesModule.DTO.SellerDTOResponse;
import com.csm.MedicalCareSys.SalesModule.model.Insurance;
import com.csm.MedicalCareSys.SalesModule.model.Seller;
import com.csm.MedicalCareSys.SalesModule.repository.InsuranceRepository;
import com.csm.MedicalCareSys.SalesModule.repository.SellerRepository;
import com.csm.MedicalCareSys.Exceptions.NotFoundException;
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

package com.csm.Dunimed.SalesModule.controller;

import com.csm.Dunimed.MedicalCareModule.DTO.DoctorDTORequest;
import com.csm.Dunimed.MedicalCareModule.DTO.DoctorDTOResponse;
import com.csm.Dunimed.MedicalCareModule.model.Doctor;
import com.csm.Dunimed.MedicalCareModule.repository.DoctorRepository;
import com.csm.Dunimed.SalesModule.DTO.SellerDTORequest;
import com.csm.Dunimed.SalesModule.DTO.SellerDTOResponse;
import com.csm.Dunimed.SalesModule.model.Seller;
import com.csm.Dunimed.SalesModule.repository.SellerRepository;
import com.csm.Dunimed.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("seller")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping("list")
    public List<SellerDTOResponse> getAllSellers(){
        return sellerRepository.findAll()
                .stream()
                .map(SellerDTOResponse::of)
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public SellerDTOResponse getSellerById(@PathVariable Integer id){
        return sellerRepository.findById(id)
                .map(SellerDTOResponse::of)
                .orElseThrow(() -> new NotFoundException("Seller Not Found"));
    }

    @PostMapping
    public SellerDTOResponse SaveSeller(@RequestBody SellerDTORequest request) {
        try {
            return SellerDTOResponse.of(sellerRepository.save(Seller.of(request)));
        } catch (Exception e) {
            throw new PersistenceException("Error saving the Seller");
        }
    }

    @DeleteMapping("{id}")
    public String deleteSeller(@PathVariable Integer id){
        try {

            sellerRepository.deleteById(id);
            return "Sucesso";
        }catch (Exception e){
            throw new PersistenceException("Error deleting Seller");
        }
    }

}

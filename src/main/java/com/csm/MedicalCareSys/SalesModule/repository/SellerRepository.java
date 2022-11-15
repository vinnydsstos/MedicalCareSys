package com.csm.MedicalCareSys.SalesModule.repository;

import com.csm.MedicalCareSys.SalesModule.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
}
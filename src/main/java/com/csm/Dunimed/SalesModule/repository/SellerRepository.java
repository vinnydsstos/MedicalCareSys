package com.csm.Dunimed.SalesModule.repository;

import com.csm.Dunimed.SalesModule.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
}
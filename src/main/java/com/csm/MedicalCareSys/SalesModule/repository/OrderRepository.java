package com.csm.MedicalCareSys.SalesModule.repository;

import com.csm.MedicalCareSys.SalesModule.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
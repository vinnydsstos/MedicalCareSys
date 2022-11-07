package com.csm.Dunimed.SalesModule.repository;

import com.csm.Dunimed.SalesModule.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
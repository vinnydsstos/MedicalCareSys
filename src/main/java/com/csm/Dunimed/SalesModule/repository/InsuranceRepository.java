package com.csm.Dunimed.SalesModule.repository;

import com.csm.Dunimed.SalesModule.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}
package com.csm.MedicalCareSys.SalesModule.repository;

import com.csm.MedicalCareSys.SalesModule.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {
}
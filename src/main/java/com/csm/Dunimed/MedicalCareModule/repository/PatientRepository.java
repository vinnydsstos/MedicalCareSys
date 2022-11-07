package com.csm.Dunimed.MedicalCareModule.repository;

import com.csm.Dunimed.MedicalCareModule.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
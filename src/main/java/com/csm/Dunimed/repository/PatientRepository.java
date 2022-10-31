package com.csm.Dunimed.repository;

import com.csm.Dunimed.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
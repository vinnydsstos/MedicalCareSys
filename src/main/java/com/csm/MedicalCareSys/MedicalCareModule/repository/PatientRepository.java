package com.csm.MedicalCareSys.MedicalCareModule.repository;

import com.csm.MedicalCareSys.MedicalCareModule.model.Patient;
import com.csm.MedicalCareSys.MedicalCareModule.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
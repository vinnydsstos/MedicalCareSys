package com.csm.Dunimed.MedicalCareModule.repository;

import com.csm.Dunimed.MedicalCareModule.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
package com.csm.MedicalCareSys.MedicalCareModule.repository;

import com.csm.MedicalCareSys.MedicalCareModule.model.Doctor;
import com.csm.MedicalCareSys.MedicalCareModule.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
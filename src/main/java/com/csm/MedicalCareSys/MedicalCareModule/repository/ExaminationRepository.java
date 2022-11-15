package com.csm.MedicalCareSys.MedicalCareModule.repository;

import com.csm.MedicalCareSys.MedicalCareModule.model.Examination;
import com.csm.MedicalCareSys.MedicalCareModule.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Integer> {
}